import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers;


    // Constructor
    public Bank(){
        this.customers = new ArrayList<>();
    }
    public void addCustomer(String username, String password) {
        Customer c = new Customer(username, password, true, generateAccountNumber());
        customers.add(c);
    }
    public Customer findCustomer(String username, String password){
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (username.equals(customers.get(i).getUsername()) && password.equals(customers.get(i).getPassword()) && (customers.get(i).getActive())) {
                // if credentials are correct, store the logged-in index and display the main menu
                index = i;
                break;
            }
        }
        if (index == -1){
            return null;
        }
        return customers.get(index);
    }
    public String generateAccountNumber(){
        return Integer.toString(customers.size());
    }
    public boolean usernameExists(String username){
        boolean exists = false;
        for (int i = 0; i < customers.size(); i++) {
            if (username.equals(customers.get(i).getUsername())) {
                exists = true;
                break;
            }
        }
        return exists;
    }
}
