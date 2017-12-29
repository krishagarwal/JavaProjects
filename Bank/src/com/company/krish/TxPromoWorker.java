package com.company.krish;

public class TxPromoWorker extends TxWorker{

    public TxPromoWorker(BankAccount account, char txType, int amt){
        super(account, txType, amt);
    }

    public void run(){
        synchronized (account){
            if (txType == 'w'){
                account.withdraw(amt);
            } else if (txType == 'd'){
                account.deposit(amt);
                if (account.getBalance() > 500){
                    int bonus = (int)((account.getBalance() - 500) * 0.1);
                    account.deposit(bonus);
                }
            }
        }
    }
}
