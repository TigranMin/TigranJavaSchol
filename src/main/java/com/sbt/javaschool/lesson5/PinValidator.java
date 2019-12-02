package com.sbt.javaschool.lesson5;

import com.sbt.javaschool.lesson5.Exceptions.AccountIsLockedException;

public class PinValidator {

    private TerminalServer terminalServer;

    public PinValidator(TerminalServer terminalServer) {
        this.terminalServer = terminalServer;
    }

    public void validatePin(Long accountNumber, Integer pin) throws AccountIsLockedException {
        terminalServer.pinChecker(accountNumber, pin);
    }

}
