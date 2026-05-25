//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Customer {
    private String username;
    private String password;
    private boolean active;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;

    public Customer(String username, String password, boolean active, String accountNumber) {
        this.setUsername(username);
        this.setPassword(password);
        this.setActive(active);
        this.checkingAccount = new CheckingAccount(accountNumber, (double)0.0F);
        this.savingsAccount = new SavingsAccount(accountNumber, (double)0.0F);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CheckingAccount getCheckingAccount() {
        return this.checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return this.savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public void isDeactivated() {
    }
}
