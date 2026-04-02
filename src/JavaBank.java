
import java.util.Scanner;

import static java.lang.System.exit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JavaBank {
    public static void main(String[] args) {

        // Parallel Array list
        String[] usernames = new String[100];
        String[] passwords = new String[100];
        double[] checkingBal = new double[100];
        double[] savingsBal = new double[100];
        boolean[] isActive = new boolean[100];
        int accountCount = 0;             // tracks how many accounts exist


        // Header Display
        System.out.println("============================");
        System.out.println("\tWelcome to JavaBank"); // come back to fix the alignment later
        System.out.println("============================");


        // Boolean for comparisons
        boolean isMatch = true;

        // Input stream
        Scanner input = new Scanner(System.in);

        // User choice selection variable
        int choice = 0;
        String username;
        String password;


        do {
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid option. Please try again.");
                input.next();
                continue;
            }
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                // Prompts for a username
                System.out.print("Create username: ");
                username = input.nextLine().toLowerCase();

                if (username.contains(" ") || !username.equals(username.trim())) {
                    System.out.println("no spaces allowed");
                    continue;
                }
                // Checks that the username does not already exist
                boolean exists = false;
                for (int i = 0; i < accountCount; i++) {
                    if (username.equals(usernames[i])) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    System.out.println("Username already exists. Please choose another.");
                    continue;
                }
                // Prompts for a password
                System.out.print("Create password: ");
                password = input.next();
                if (password.length() < 6) {
                    System.out.println("minimum 6 characters");
                    continue;
                }
                // Stores the username, password, and initial balances of $0.00
                usernames[accountCount] = username;
                passwords[accountCount] = password;
                checkingBal[accountCount] = 0.00;
                isActive[accountCount] = true;
                // Increment accountCount
                accountCount++;
                // Displays if account was created successfully.
                System.out.print("Account created successfully! Welcome, " + username);
                System.out.println();
            }
            // LOGIN PORTION
            // Prompts user for username and password
            if (choice == 2) {
                System.out.print("Enter username: ");
                username = input.next().toLowerCase().trim();
                System.out.print("Enter password: ");
                password = input.next();


                // Login storage
                int loggedInIndex = -1;


                for (int i = 0; i < accountCount; i++) {
                    if (username.equals(usernames[i]) && password.equals(passwords[i]) && (isActive[i] == true)) {
                        // FINISH THIS SECTION
                        // if credentials are correct, store the logged-in index and display the main menu
                        loggedInIndex = i;
                        break;
                    }
                }
                // Display menu
                System.out.println("============================");
                System.out.println("\tHello, " + username);
                System.out.println("============================");

                if (loggedInIndex == -1) {
                    System.out.println("Invalid username or password.");
                    break;
                }

                int menu = 0;

                do {

                    System.out.println("1. View Balances");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Transfer (Checking <-> saving)");
                    System.out.println("5. Transaction History <- Bonus (NOT IMPLEMENTED YET)");
                    System.out.println("6. Logout");
                    System.out.print("Enter Choice: ");
                    if (!input.hasNextInt()) {
                        System.out.println("Invalid option. Please try again.");
                        input.next();
                        continue;
                    }

                    //input variable
                    menu = input.nextInt();
                    double amount = 0;

                    switch (menu) {
                        case 1:
                            System.out.println("--- Your Balances ---");
                            System.out.printf("Checking: $ %.2f", checkingBal[accountCount]);
                            System.out.println();
                            System.out.printf("Savings: $ %.2f", savingsBal[accountCount]);
                            System.out.println();
                            break;
                        case 2:
                            // Double check this section
                            System.out.println("1. checking \t 2. Savings");
                            if (!input.hasNextInt()) {
                                System.out.println("Invalid input. Please enter a number.");
                                input.next();
                                continue;
                            }
                            menu = input.nextInt();
                            if (menu == 1) {
                                System.out.print("Deposited Amount: ");
                                if (!input.hasNextDouble()) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    input.next();
                                    continue;
                                }
                                amount = input.nextDouble();
                                if (amount <= 0) {
                                    System.out.println("Deposit amount must be greater than zero.");
                                }
                                if (amount > 0) {
                                    checkingBal[accountCount] += amount;
                                    System.out.printf("Checking: $%.2f", checkingBal[accountCount]);
                                    System.out.println();
                                } else {
                                    System.out.println("You didn't enter a number");
                                }
                            }
                            if (menu == 2) {
                                System.out.print("Deposited Amount: ");
                                if (!input.hasNextDouble()) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    input.next();
                                    continue;
                                }
                                amount = input.nextDouble();
                                if (amount <= 0) {
                                    System.out.println("Deposit amount must be greater than zero.");
                                }
                                if (amount > 0) {
                                    savingsBal[accountCount] += amount;
                                    System.out.printf("Savings: $%.2f", savingsBal[accountCount]);
                                    System.out.println();
                                } else {
                                    System.out.println("You didn't enter a number");
                                }
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
                            if (menu == 1) {
                                System.out.print("Withdraw Amount: ");
                                if (!input.hasNextDouble()) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    input.next();
                                    continue;
                                }
                                amount = input.nextDouble();
                                if (amount <= 0) {
                                    System.out.println("Withdraw amount must be greater than zero.");
                                }
                                if (amount > 0) {
                                    checkingBal[accountCount] -= amount;
                                    System.out.printf("Checking: $%.2f", checkingBal[accountCount]);
                                    System.out.println();
                                } else {
                                    System.out.println("You didn't enter a number");
                                }
                            }
                            if (menu == 2) {
                                System.out.print("Withdraw Amount: ");
                                if (!input.hasNextDouble()) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    input.next();
                                    continue;
                                }
                                amount = input.nextDouble();
                                if (amount <= 0) {
                                    System.out.println("Withdraw amount must be greater than zero.");
                                }
                                if (amount > 0) {
                                    savingsBal[accountCount] -= amount;
                                    System.out.printf("Savings: $%.2f", savingsBal[accountCount]);
                                    System.out.println();
                                } else {
                                    System.out.println("You didn't enter a number");
                                }
                            }
                            break;
                            // Transfers money between accounts
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
                                if (amount > 0 && checkingBal[accountCount] > 0) {
                                    savingsBal[accountCount] += amount;
                                    checkingBal[accountCount] -= amount;

                                    System.out.println("--- Your Balances ---");
                                    System.out.printf("Checking: $ %.2f", checkingBal[accountCount]);
                                    System.out.println();
                                    System.out.printf("Savings: $ %.2f", savingsBal[accountCount]);
                                    System.out.println();
                                } else {
                                    System.out.println("Invalid amount! No money to transfer.");
                                }
                            }
                            if (menu == 2) {
                                System.out.println("Transfer amount to Checking: ");
                                if (!input.hasNextDouble()) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    input.next();
                                    continue;
                                }
                                amount = input.nextDouble();
                                if (amount > 0 && savingsBal[accountCount] > 0) {
                                    checkingBal[accountCount] += amount;
                                    savingsBal[accountCount] -= amount;
                                    System.out.println("--- Your Balances ---");
                                    System.out.printf("Checking: $ %.2f", checkingBal[accountCount]);
                                    System.out.println();
                                    System.out.printf("Savings: $ %.2f", savingsBal[accountCount]);
                                    System.out.println();
                                } else {
                                    System.out.println("Invalid amount! No money to transfer.");
                                }
                            }
                            break;
                        case 5:

                        case 6:
                            loggedInIndex = -1;
                            System.out.println("Logged out!");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");

                    }
                } while (menu != 6);
                // Use isActive[i] == true to prevent login to a closed account
                

            }
            if (choice == 3) {
                System.out.println("Exited Program");
                break;
            }
        }while (choice != 3);
            System.out.println("You have been logged out. Goodbye!");

        }


    }