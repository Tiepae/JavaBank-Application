import java. util.*;


public class Customer {

    private String username;
    private String password;
    private boolean active;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;


    // Constructor
    public Customer(String username, String password, boolean active, String accountNumber) {
        setUsername(username);
        setPassword(password);
        setActive(active);
        this.checkingAccount = new CheckingAccount(accountNumber,0.00);
        this.savingsAccount = new SavingsAccount(accountNumber,0.00);
    }

    private void setActive(boolean active) {
        this.active = active;
    }

    // Getters
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean getActive() {
        return this.active;
    }

    public CheckingAccount getCheckingAccount(){
        return this.checkingAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return this.savingsAccount;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}



//Create a new Customer object
//Create one CheckingAccount object for the customer
//Create one SavingsAccount object for the customer
//Store the customer in the Bank class


