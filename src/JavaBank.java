import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JavaBank {

    private static Bank bank = new Bank();

    public static String userNameValidation(Scanner input) {
        String username;
        System.out.print("Create username: ");
        while (true) {
            username = input.nextLine().toLowerCase();
            if (username.contains(" ") || !username.equals(username.trim())) {
                System.out.println("no spaces allowed");
                continue;
            }
            // Checks that the username does not already exist
            if (bank.usernameExists(username)) {
                System.out.println("Username already exists. Please choose another.");
                continue;
            }
            break;
        }
        return username;
    }

    public static String passwordValidation(Scanner input) {
        String password;
        System.out.print("Create password: ");
        while (true) {
            password = input.next();
            if (password.length() < 6) {
                System.out.println("minimum 6 characters");
                continue;
            }
            break;
        }
        return password;

    }

    public static void createAccount(Scanner input) {
        // Prompts for a username
        String username = userNameValidation(input);
        // Prompts for a password
        String password = passwordValidation(input);

        bank.addCustomer(username, password);
        // Displays if account was created successfully.
        System.out.println();
        System.out.print("Account created successfully! Welcome, " + username);
        System.out.println();


    }


        public static void viewBalance(Customer customer) {
            System.out.println();
            System.out.println("--- Your Balances ---");
            System.out.printf("Checking: $ %.2f", customer.getCheckingAccount().getBalance());
            System.out.println();
            System.out.printf("Savings: $ %.2f", customer.getSavingsAccount().getBalance());
            System.out.println();
        }
        public static void UserMenu(Scanner input, Customer customer) throws Transactable.InvalidAmountException, Transactable.InsufficientFundsException {


            int menu = 0;
            do {
                System.out.println();
                System.out.println("1. View Balances");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer (Checking <-> saving)");
                System.out.println("5. Transaction History <- Extra content (Not implemented yet)");
                System.out.println("6. Logout");
                System.out.println();
                System.out.print("Enter Choice: ");
                if (!input.hasNextInt()) {
                    System.out.println("Invalid option. Please try again.");
                    input.next();
                    continue;
                }

                //input variable
                menu = input.nextInt();
                double amount;

                switch (menu) {
                    // Check Balance option
                    case 1:
                        viewBalance(customer);
                        break;
                    case 2:
                        System.out.println("1. checking \t 2. Savings");
                        if (!input.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                            continue;
                        }
                        menu = input.nextInt();
                        System.out.print("Deposited Amount: ");
                        amount = input.nextDouble();
                        if (menu == 1) {
                            customer.getCheckingAccount().deposit(amount);
                        } else if (menu == 2) {
                            customer.getSavingsAccount().deposit(amount);
                        } else {
                            System.out.print("Invalid Choice");
                        }
                        break;
                    case 3:
                        System.out.println("1. checking \t 2. Savings");
                        if (!input.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                            continue;
                        }
                        menu = input.nextInt();
                        System.out.print("Withdraw Amount: ");
                        amount = input.nextDouble();
                        if (menu == 1) {
                            customer.getCheckingAccount().withdraw(amount);
                        } else if (menu == 2) {
                            customer.getSavingsAccount().withdraw(amount);
                        } else {
                            System.out.print("Invalid Choice");
                        }
                        break;
                    case 4:
                        System.out.println("1. Checking -> Savings 2. Savings -> Checking");
                        if (!input.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                            continue;
                        }
                        menu = input.nextInt();
                        if (menu == 1) {
                            System.out.println("Transfer amount to Savings: ");
                            if (!input.hasNextDouble()) {
                                System.out.println("Invalid input. Please enter a number.");
                                input.next();
                                continue;
                            }
                            amount = input.nextDouble();
                            customer.getCheckingAccount().withdraw(amount);
                            customer.getSavingsAccount().deposit(amount);


                        } else if (menu == 2) {
                            System.out.println("Transfer amount to Checking: ");
                            if (!input.hasNextDouble()) {
                                System.out.println("Invalid input. Please enter a number.");
                                input.next();
                                continue;
                            }
                            amount = input.nextDouble();
                            customer.getSavingsAccount().withdraw(amount);
                            customer.getCheckingAccount().deposit(amount);

                        }
                        viewBalance(customer);
                        break;
                        // Bonus option (Not implemented)
                    case 5:
                        // Logout option
                    case 6:
                        int loggedInIndex = -1;
                        System.out.println("Logged out!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }


            } while (true);
        }


        public static void main(String[] args) throws Transactable.InvalidAmountException, Transactable.InsufficientFundsException {
            // YOU LEFT OFF HERE FIGURE OUT HOW TO ADD METHODS

            // Header Display
            System.out.println("============================");
            System.out.println("\tWelcome to JavaBank"); // come back to fix the alignment later
            System.out.println("============================");


            // Input stream
            Scanner input = new Scanner(System.in);

            // User choice selection variable
            int choice = 0;
            String username;
            String password;


            while(true) {
                System.out.println("1. Create Account");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println();
                System.out.print("Enter choice: ");
                if (!input.hasNextInt()) {
                    System.out.println("Invalid option. Please try again.");
                    input.next();
                    continue;
                }
                choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    createAccount(input); //CHANGE THIS TO WORK WITH BANK INSTEAD OF CUSTOMERS.SIZE()
                }
                // LOGIN PORTION
                // Prompts user for username and password
                if (choice == 2) {
                    System.out.print("Enter username: ");
                    username = input.next().toLowerCase().trim();
                    System.out.print("Enter password: ");
                    password = input.next();
                    // Login storage
                    Customer c = bank.findCustomer(username, password);
                    if(c == null){
                        System.out.println("Incorrect username or password!");
                        continue;
                    }
                    // Display menu
                    System.out.println("============================");
                    System.out.println("\tHello, " + username);
                    System.out.println("============================");
                    UserMenu(input, c);
                }
                if (choice == 3) {
                    System.out.println("Exited Program");
                    break;
                }
            }
        }


        }

