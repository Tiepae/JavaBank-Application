//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public abstract class Account implements Transactable {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
    }

    protected Account() {
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount < (double)0.0F) {
            throw new InvalidAmountException("Must deposit using a number greater than 0");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount < (double)0.0F) {
            throw new InvalidAmountException("Invalid amount! Must be greater than 0");
        } else if (amount > this.balance) {
            throw new InsufficientFundsException("Not enough funds in account!");
        } else {
            this.balance -= amount;
        }
    }

    public abstract String getAccountType();
}
