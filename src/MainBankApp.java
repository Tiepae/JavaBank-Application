//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Scanner;

public class MainBankApp {
    public static Bank bank = new Bank();

    public MainBankApp() {
    }

    public static String userNameValidation(Scanner input) {
        System.out.print("Create username: ");

        while(true) {
            String username = input.nextLine().toLowerCase();
            if (!username.contains(" ") && username.equals(username.trim())) {
                if (!bank.userNameDuplicate(username)) {
                    return username;
                }

                System.out.println("Username already exists. Please choose another.");
            } else {
                System.out.println("no spaces allowed");
            }
        }
    }

    public static String passwordValidation(Scanner input) {
        System.out.print("Create password: ");

        while(true) {
            String password = input.next();
            if (password.length() >= 6) {
                return password;
            }

            System.out.println("minimum 6 characters");
        }
    }

    public static void accountCreation(Scanner input) {
        String username = userNameValidation(input);
        String password = passwordValidation(input);
        bank.createCustomer(username, password);
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

        while(true) {
            System.out.println();
            System.out.println("1. View Balances");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer (Checking <-> saving)");
            System.out.println("5. Transaction History <- Extra content (Not implemented yet)");
            System.out.println("6. Logout");
            System.out.println();
            System.out.print("Enter Choice: ");
            if (input.hasNextInt()) {
                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        viewBalance(customer);
                        break;
                    case 2:
                        System.out.println("1. checking \t 2. Savings");
                        if (!input.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                        } else {
                            menu = input.nextInt();
                            System.out.print("Deposited Amount: ");
                            double amount = input.nextDouble();
                            if (menu == 1) {
                                customer.getCheckingAccount().deposit(amount);
                            } else if (menu == 2) {
                                customer.getSavingsAccount().deposit(amount);
                            } else {
                                System.out.print("Invalid Choice");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("1. checking \t 2. Savings");
                        if (!input.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                        } else {
                            menu = input.nextInt();
                            System.out.print("Withdraw Amount: ");
                            double amount = input.nextDouble();
                            if (menu == 1) {
                                customer.getCheckingAccount().withdraw(amount);
                            } else if (menu == 2) {
                                customer.getSavingsAccount().withdraw(amount);
                            } else {
                                System.out.print("Invalid Choice");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("1. Checking -> Savings 2. Savings -> Checking");
                        if (!input.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                        } else {
                            menu = input.nextInt();
                            if (menu == 1) {
                                System.out.println("Transfer amount to Savings: ");
                                if (!input.hasNextDouble()) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    input.next();
                                    continue;
                                }

                                double amount = input.nextDouble();
                                customer.getCheckingAccount().withdraw(amount);
                                customer.getSavingsAccount().deposit(amount);
                            } else if (menu == 2) {
                                System.out.println("Transfer amount to Checking: ");
                                if (!input.hasNextDouble()) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    input.next();
                                    continue;
                                }

                                double amount = input.nextDouble();
                                customer.getSavingsAccount().withdraw(amount);
                                customer.getCheckingAccount().deposit(amount);
                            }

                            viewBalance(customer);
                        }
                        break;
                    case 5:
                    case 6:
                        int loggedInIndex = -1;
                        System.out.println("Logged out!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Invalid option. Please try again.");
                input.next();
            }
        }
    }

    public static void main(String[] args) throws Transactable.InvalidAmountException, Transactable.InsufficientFundsException {
        System.out.println("============================");
        System.out.println("\tWelcome to JavaBank");
        System.out.println("============================");
        int choice = 0;
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter Choice: ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid option. Please try again.");
                input.next();
            } else {
                choice = input.nextInt();
                input.nextLine();
                if (choice == 1) {
                    accountCreation(input);
                }

                if (choice == 2) {
                    System.out.print("Enter username: ");
                    String username = input.next().toLowerCase().trim();
                    System.out.print("Enter password: ");
                    String password = input.next();
                    Customer c = bank.login(username, password);
                    if (c == null) {
                        System.out.println("Incorrect username or password!");
                        continue;
                    }

                    System.out.println("============================");
                    System.out.println("\tHello, " + username);
                    System.out.println("============================");
                    UserMenu(input, c);
                }

                if (choice == 3) {
                    System.out.println("Exited Program");
                    return;
                }
            }
        }
    }
}
