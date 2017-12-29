package com.company.krish;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

@ProcessedBy(AccountWorker.class)
public class BankAccount implements Serializable{

    private static final long serialVersionUID = 1252370172721129424L;
    private String id;
    private int balance = 0;
    private char lastTxType;
    private int lastTxAmt;

    BankAccount(String id){
        this.id = id;
    }

    BankAccount(String id, int balance){
        this.id = id;
        this.balance = balance;
    }

    public char getLastTxType() {
        return lastTxType;
    }

    public int getLastTxAmt() {
        return lastTxAmt;
    }

    synchronized void deposit(int amount){
        balance += amount;
        lastTxAmt = amount;
        lastTxType = 'd';
    }

    synchronized void withdraw(int amount){
        balance -= amount;
        lastTxAmt = amount;
        lastTxType = 'w';
    }

    synchronized int getBalance(){
        return balance;
    }

    String getId(){
        return id;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        ObjectInputStream.GetField fields = in.readFields();
        id = (String) fields.get("id", null);
        balance = fields.get("balance", 0);
        lastTxType = fields.get("lastTxType", 'u');
        lastTxAmt = fields.get("lastTxAmt", -1);
    }

}
