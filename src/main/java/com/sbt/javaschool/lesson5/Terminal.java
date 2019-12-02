package com.sbt.javaschool.lesson5;

import com.sbt.javaschool.lesson5.Exceptions.AccountIsLockedException;
import com.sbt.javaschool.lesson5.Exceptions.IncorrectPinException;

public interface Terminal {

    void withdrawMoney(Long accountNumber, Integer pin, double amount) throws AccountIsLockedException, IncorrectPinException;

    void putMoney(Long accountNumber, Integer pin, double amount) throws AccountIsLockedException, IncorrectPinException;

    double balanceEnquiry(Long accountNumber, Integer pin) throws IncorrectPinException, AccountIsLockedException;

    void balanceOnScreen(Long accountNumber, Integer pin) throws IncorrectPinException, AccountIsLockedException;

    void changePIN(Long accountNumber, Integer oldPin, Integer newPin);

    void returnCard();
}
