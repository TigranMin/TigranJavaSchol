package lesson5;

import lesson5.Exceptions.AccountIsLockedException;
import lesson5.Exceptions.IncorrectPinException;

public class TerminalImpl implements Terminal{

    private PinValidator pinValidator;
    private TerminalServer terminalServer;
    //private Account account;

    @Override
    public void withdrawMoney(Long accountNumber, Integer pin, double amount) throws AccountIsLockedException, IncorrectPinException {
        if (terminalServer.pinChecker(accountNumber, pin)){
            TerminalServer.getAccaunts().get(accountNumber).setAccountBalance(TerminalServer.getAccaunts().get(accountNumber).getAccountBalance() - amount);
            balanceOnScreen(accountNumber, pin);
        } else{
            TerminalServer.getAccaunts().get(accountNumber).incrementCountOfWrongPins();
            throw new IncorrectPinException();
        }
    }

    @Override
    public void putMoney(Long accountNumber, Integer pin, double amount) throws AccountIsLockedException, IncorrectPinException {
        if (terminalServer.pinChecker(accountNumber, pin)){
            TerminalServer.getAccaunts().get(accountNumber).setAccountBalance(TerminalServer.getAccaunts().get(accountNumber).getAccountBalance() + amount);
            balanceOnScreen(accountNumber, pin);
        } else{
            TerminalServer.getAccaunts().get(accountNumber).incrementCountOfWrongPins();
            throw new IncorrectPinException();
        }
    }

    @Override
    public double balanceEnquiry(Long accountNumber, Integer pin) throws AccountIsLockedException, IncorrectPinException {
        if (terminalServer.pinChecker(accountNumber, pin)){
            return TerminalServer.getAccaunts().get(accountNumber).getAccountBalance();
        } else{
            TerminalServer.getAccaunts().get(accountNumber).incrementCountOfWrongPins();
            throw new IncorrectPinException();
        }
    }

    @Override
    public void balanceOnScreen(Long accountNumber, Integer pin) throws IncorrectPinException, AccountIsLockedException {
        if (terminalServer.pinChecker(accountNumber, pin)){
            System.out.println(TerminalServer.getAccaunts().get(accountNumber).getAccountBalance());
        } else{
            TerminalServer.getAccaunts().get(accountNumber).incrementCountOfWrongPins();
            throw new IncorrectPinException();
        }
    }

    @Override
    public void changePIN(Long accountNumber, Integer oldPin, Integer newPin) {

    }

    @Override
    public void returnCard() {

    }
}
