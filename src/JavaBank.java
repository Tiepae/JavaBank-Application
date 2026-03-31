//import java.util.Arrays;
import java.util.Arrays;
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
        int choice;
        String username;
        String password;

        do {
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();


            if (choice == 1) {
                // Prompt for a username (no spaces allowed; reject and re-prompt if spaces are entered)
                System.out.println("Create username: ");
                username = input.next();
                if (username.contains(" ")) {
                    System.out.println("no spaces allowed");
                    continue;
                }
                // Check that the username does not already exist (loop through usernames[] with equals())
                // If the username is taken, display "Username already exists. Please choose another." and re-prompt
                for (int i = 0; i < accountCount; i++) {
                    if (username.equals(usernames[i])) {
                        System.out.print("Username already exists. Please choose another.");
                        continue;
                    }
                }
                // Prompt for a password (minimum 6 characters; reject and re-prompt if too short)
                System.out.print("Create password: ");
                password = input.next();
                if (password.length() < 6) {
                    System.out.println("minimum 6 characters");
                    continue;
                }
                // Store the username, password, and initial balances of $0.00 in the next available array slot
                usernames[accountCount] = username;
                passwords[accountCount] = password;
                checkingBal[accountCount] = 0.00;
                isActive[accountCount] = true;
                // Increment accountCount
                accountCount++;
                // Display "Account created successfully! Welcome, [username]."
                System.out.print("Account created successfully! Welcome, " + username);
                System.out.println();
            }
            // LOGIN PORTION
            // Prompt user for username and password
            if (choice == 2) {
                System.out.print("Enter username: ");
                username = input.next();
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
                // Switch Statement
                if (loggedInIndex == -1) {
                    System.out.println("Invalid username or password.");
                    break;
                }

                int menu = 0;

                do {

                    System.out.println("1. View Balances");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Transfer (Checking + saving)");
                    System.out.println("5. Transaction History + Bonus");
                    System.out.println("6. Logout");
                    System.out.print("Enter Choice: ");

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
                            // DOUBLE CHECK CASE 2 & 3 ************
                        case 2:
                            // Double check this section
                            System.out.println("1. checking \t 2. Savings");
                            menu = input.nextInt();
                            if (menu == 1){
                                System.out.print("Deposited Amount: ");
                                amount = input.nextDouble();
                                if(amount <= 0){
                                    System.out.println("Deposit amount must be greater than zero.");
                                }if(amount > 0){
                                    checkingBal[accountCount] += amount;
                                    System.out.printf("Checking: $%.2f", checkingBal[accountCount]);
                                    System.out.println();
                                }else{
                                    System.out.println("You didn't enter a number");
                                }
                            } if (menu == 2) {
                                System.out.print("Deposited Amount: ");
                                amount = input.nextDouble();
                                if (amount <= 0){
                                    System.out.println("Deposit amount must be greater than zero.");
                                } if(amount > 0){
                                    savingsBal[accountCount] += amount;
                                    System.out.printf("Savings: $%.2f", savingsBal[accountCount]);
                                    System.out.println();
                            }else{
                                System.out.println("You didn't enter a number");
                            }
                        }
                            break;
                        case 3:
                            System.out.println("1. checking \t 2. Savings");
                            menu = input.nextInt();
                            if (menu == 1){
                                System.out.print("Withdraw Amount: ");
                                amount = input.nextDouble();
                                if (amount <= 0){
                                    System.out.println("Withdraw amount must be greater than zero.");
                                }if (amount > 0){
                                    checkingBal[accountCount] -= amount;
                                    System.out.printf("Checking: $%.2f", checkingBal[accountCount]);
                                    System.out.println();
                                } else{
                                    System.out.println("You didn't enter a number");
                                }
                            }if (menu == 2){
                                System.out.print("Withdraw Amount: ");
                                amount = input.nextDouble();
                                if (amount <= 0){
                                System.out.println("Withdraw amount must be greater than zero.");
                                }  if (amount > 0) {
                                    savingsBal[accountCount] -= amount;
                                    System.out.printf("Savings: $%.2f", savingsBal[accountCount]);
                                    System.out.println();
                                }else{
                                    System.out.println("You didn't enter a number");
                            }
                            }
                            break;
                        case 4:

                        case 5:

                        case 6:
                            loggedInIndex = -1;
                            System.out.println("Logged out!");
                            break;

                    }
                } while (menu != 6);
                // Use isActive[i] == true to prevent login to a closed account

                if (choice == 3) {
                    System.out.println("Exited Program");
                    break;
                }


            }
        }while (choice != 3);
            System.out.println("You have been logged out. Goodbye!");

        }


    }