package com.sbt.javaschool.lesson11.part2;

public class AccountExample implements Runnable {

    private Account acct = new Account();

    private void makeWithdrawal(int amt) {
        if (acct.getBalance() >= amt) {
            acct.withdraw(amt);
        }

    }

    public void runThread() {
        new Thread(this).start();
        new Thread(this).start();
    }

    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdrawal(10);
            if (acct.getBalance() < 0) {
                System.out.println("account is overdrawn!");
            }
        }
    }


    public static void main(String[] args) {

    }
}
