package com.company.krish;

@ProcessedBy(AccountWorker.class)
public final class HighVolumeAccount extends BankAccount implements Runnable {

    public HighVolumeAccount(String id, int balance){
        super(id, balance);
    }

    public HighVolumeAccount(String id) {
        super(id);
    }

    private int[] readDailyWithdrawals(){
        return new int[]{300, 650, 390, 800};
    }

    private int[] readDailyDeposits(){
        return new int[]{750, 680, 430, 200};
    }

    public void run() {
        for(int depositAmt : readDailyDeposits()){
            deposit(depositAmt);
        }

        for(int withdrawalAmt : readDailyWithdrawals()){
            withdraw(withdrawalAmt);
        }
    }
}
