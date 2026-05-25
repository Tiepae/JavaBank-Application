//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.ArrayList;

public class Bank extends Account {
    private ArrayList<Customer> customers = new ArrayList();

    public Bank() {
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public void createCustomer(String username, String password) {
        Customer c = new Customer(username, password, true, this.getAccountNumber());
        this.customers.add(c);
    }

    public Customer login(String username, String password) {
        int index = -1;

        for(int i = 0; i < this.customers.size(); ++i) {
            if (username.equals(((Customer)this.customers.get(i)).getUsername()) && password.equals(((Customer)this.customers.get(i)).getPassword()) && ((Customer)this.customers.get(i)).getActive()) {
                index = i;
                break;
            }
        }

        return index == -1 ? null : (Customer)this.customers.get(index);
    }

    public boolean userNameDuplicate(String username) {
        boolean exists = false;

        for(int i = 0; i < this.customers.size(); ++i) {
            if (username.equals(((Customer)this.customers.get(i)).getUsername())) {
                exists = true;
                break;
            }
        }

        return exists;
    }

    public String getAccountType() {
        return "";
    }
}
