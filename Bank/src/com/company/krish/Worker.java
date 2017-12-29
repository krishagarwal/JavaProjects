package com.company.krish;


public class Worker implements Runnable {

    private BankAccount account;
    private int workerNum;

    public Worker(BankAccount account, int num){
        this.account = account;
        workerNum = num;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {

            synchronized (account) {
                account.deposit(10);
                System.out.println(account.getBalance() + " - " + workerNum);
            }
        }
    }
}
