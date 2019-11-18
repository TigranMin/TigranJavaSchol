package lesson5;

public class Account {

    private Long accountNumber;
    private Integer pin;

    void setAccountBalance(double accountBalance) {
        AccountBalance = accountBalance;
    }

    private double AccountBalance;

    public Long getAccountNumber() {
        return accountNumber;
    }

    Integer getPin() {
        return pin;
    }

    double getAccountBalance() {
        return AccountBalance;
    }

    void incrementCountOfWrongPins() {
        this.countOfWrongPins ++;
    }

    int getCountOfWrongPins() {
        return countOfWrongPins;
    }

    private int countOfWrongPins;

}
