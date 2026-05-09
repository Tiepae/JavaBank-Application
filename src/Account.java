public abstract class Account implements Transactable {

    private String accountNumber;
    private double balance;

    // Constructor
    public Account(String accountNumber, double balance){
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) throws InvalidAmountException{
        if (amount < 0){
            throw new InvalidAmountException("Amount must be greater than 0");
        }
        this.balance += amount;
    }
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException{

            if (amount < 0) {
                throw new InvalidAmountException("Amount must be greater than 0");
            }


            if(amount > balance) {
                throw new InsufficientFundsException("Insufficient balance");
            }

        this.balance -= amount;
    }
    public abstract String getAccountType();
}
