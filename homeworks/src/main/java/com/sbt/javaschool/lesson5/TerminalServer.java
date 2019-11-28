package com.sbt.javaschool.lesson5;

import com.sbt.javaschool.lesson5.Exceptions.AccountIsLockedException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class TerminalServer {

    private static Map<Long, Account> accounts = new HashMap<>();

    static Map<Long, Account> getAccounts() {
        return accounts;
    }

    boolean pinChecker(Long accountNumber, Integer pin) throws AccountIsLockedException {
        Account account = accounts.get(accountNumber);
        Objects.requireNonNull(account);

        if(!(account.getPin().equals(pin))){
            account.incrementCountOfWrongPins();
            switch (account.getCountOfWrongPins()){
                case 1:
                    System.out.println("Incorrect pin. you have 2 more tries");
                    break;
                case 2:
                    System.out.println("Incorrect pin. you have 1 more try");
                    break;
                case 3:
                    throw new AccountIsLockedException();
            }
            return false;
        }
        return true;
    }

}
