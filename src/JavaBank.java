//import java.util.Arrays;
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


        // Input stream
        Scanner input = new Scanner(System.in);

        // User choice selection variable
        int choice;
        String username;
        String password;

        do{
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();


            if(choice == 1){
                // Prompt for a username (no spaces allowed; reject and re-prompt if spaces are entered)
                System.out.println("Create username: ");
                username = input.next();
                if(username.contains(" ")){
                    System.out.println("no spaces allowed");
                    continue;
                }
                // Check that the username does not already exist (loop through usernames[] with equals())
                // If the username is taken, display "Username already exists. Please choose another." and re-prompt
                for (int i = 0; i < accountCount;i++){
                   if(username.equals(usernames[i])){
                       System.out.print("Username already exists. Please choose another.");
                       continue;
                   }
                }
                // Prompt for a password (minimum 6 characters; reject and re-prompt if too short)
                System.out.print("Create password: ");
                password = input.next();
                if(password.length() < 6){
                    System.out.println("minimum 6 characters");
                    continue;
                }
                // Store the username, password, and initial balances of $0.00 in the next available array slot
                usernames[accountCount] = username;
                passwords[accountCount] = password;
                checkingBal[accountCount] = 0.00;
                // Increment accountCount
                accountCount++;
                // Display "Account created successfully! Welcome, [username]."
                System.out.print("Account created successfully! Welcome, " + username);
                System.out.println();
            }


        }while(choice != 3);
        System.out.println("Exited Program");

        }


    }