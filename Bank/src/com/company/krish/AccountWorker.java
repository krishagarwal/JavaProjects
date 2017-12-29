package com.company.krish;

@WorkHandler(false)
public class AccountWorker implements Runnable, TaskWorker{

    BankAccount bankAcct;

    @Override
    public void setTarget(Object target) {
        if(BankAccount.class.isInstance(target)){
            bankAcct = (BankAccount)target;
        } else{
            throw new IllegalArgumentException();
        }
    }

    public void doWork() {

        if(Runnable.class.isInstance(bankAcct)){
            ((Runnable)bankAcct).run();
        } else{
            run();
        }

//        Runnable r = HighVolumeAccount.class.isInstance(bankAcct) ? (HighVolumeAccount)bankAcct : this;
//        Thread t = new Thread(r);
//        t.start();
    }

    public void run() {
        char txType = 'd';
        int amt = 100;

        if(txType == 'w'){
            bankAcct.withdraw(amt);
        } else{
            bankAcct.deposit(amt);
        }
    }
}
