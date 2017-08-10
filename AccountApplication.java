import java.util.Scanner;

/**
 * Write a description of class AccountApplication here.
 * 
 * @author Andrew Beaulieu 
 * @version 11152016
 */

public class AccountApplication {
    
    private static Account list;
    private static Account account;
    private static Scanner kb;
    private static int count;
    
    /**
     * Main program
     * 
     * Asking first how big the user is expecting the account size to be
     * Then calls upon the display menu for more visual based I/O
     */
    public static void main (String[] arge) {
       kb = new Scanner (System.in);
       
       int size = 0;
       count = 1;
       boolean done = false;
       
       while (!done) {
            System.out.print ("How many items do you have? ");
            if (kb.hasNextInt())
            {
                size = kb.nextInt();
                kb.nextLine();
                
                if (size > 0)
                
                {
                    done = true;
                }
                else
                {
                    System.out.println ("Number of items must be positive");
                    System.out.println ("You entered " + size);
                }
            }
            else
            {
                System.out.println ("Input must be an integer");
                kb.nextLine();
            }
       }
       
       
       
       
       displayMenu(size);
    }
    
    /**
     * displayMenu()
     * @param size
     * 
     * asking for basic information about an account, and using that to build a new object of the
     * account class
     * 
     * Then makes a menu and uses a switch to determine what course to take next from the user input
     */
    private static void displayMenu(int size) {
        boolean done = false;
        
        System.out.println("Welcome to AccountTracker!");
        System.out.println("");
        System.out.println("Please enter the name of your bank:");
        String bankName = kb.nextLine();
        System.out.println("What type of account do you have?");
        System.out.println("Please input: Checking, savings, money market, or "
            + "Certificate of Deposit");
        String typeOfAccount = kb.nextLine();
        System.out.println("Please enter your account number:");
        String accountNumber = kb.nextLine();
        System.out.println("What is your inital balance: ");
        double initialBalance = kb.nextDouble();
        kb.nextLine();
        account = new Account (bankName, typeOfAccount, accountNumber, initialBalance, size);
            
        while (!done) {
            System.out.println("Please select from the menu"); 
            System.out.println("--------------------------------------"); 
            System.out.println("A - Add a new transaction"); 
            System.out.println("B - Remove a specificed transaction"); 
            System.out.println("C - Remove all transactions"); 
            System.out.println("D - Display account information"); 
            System.out.println("E - List all transactions"); 
            System.out.println("F - Get current balance"); 
            System.out.println("G - Quit"); 
       
            String task = kb.nextLine();
            task = task.toUpperCase();
       
            switch (task) {
                case "A":
                    addNewTrans();
                    break;
                case "B":
                    removeSelectedTrans();
                    break;
                case "C":
                    removeAllTrans();
                    break;
                case "D":
                    displayAcctInfo();
                    break;
                case "E":
                    listAllTrans();
                    break;
                case "F":
                    showCurrentBalance();
                    break;
                case "G":
                    done = true;
                    break;
                default:
                    System.out.println("Error: " + task + " is not a valid selection.");
            }
        }
    }
    
    /**
     * Method addNewTrans()
     * do-while loop from Research at MSU tutoring center
     * Instead of taking a boolean to check if it was performed, using the ! to flip the boolean
     * so Java can perform the task and then automatically check. 
     * 
     * takes basic info about a transaction, and creates a new object of the Transaction class
     * 
     * Uses a do-while loop to make sure that the user has entered a valid type of transaction
     */
    public static void addNewTrans(){
        
        System.out.println("Please enter date of transaction: ");
        String transDate = kb.nextLine();
        
        System.out.println("Please enter the type of transaction: ");
        String typeTrans;
        do {
            System.out.println("Valid types are "
                + "(deposit, withdrawal, interest payment, service charge)");
            typeTrans = kb.nextLine();
        } while (
            !typeTrans.equals("deposit") && 
            !typeTrans.equals("withdrawal") && 
            !typeTrans.equals("interest payment") && 
            !typeTrans.equals("service charge")
            );
        double howMuch;
        System.out.println("How much was the transaction?");
        howMuch = kb.nextDouble();
        kb.nextLine();
    
        Transaction trans = new Transaction (transDate, typeTrans, howMuch);
        if (!account.addTransaction(trans)) {
            System.out.println("Error: unable to add that transaction");
        }
    }
    
    /**
     * Method removeSelectedTrans()
     * do-while loop researched at MSU tutoring center
     * 
     * takes an input 'input', and also uses the do while loop to make sure that the number is 
     * greater than zero. If statement to also display an error to the user that the input is
     * invalid and has to try again.
     * 
     * combines an if statement with the method call to remove the transaction located 
     * at the input offset so that it matches the actual index location in the array.
     * the ! is used so that the action is done and then checked to see if it has been done.
     * 
     */
    public static void removeSelectedTrans() {
        
        System.out.println("Select which transaction item to remove: ");
        int input;
        do {
            input = kb.nextInt();
            kb.nextLine();
            if (input <= 0) {
                System.out.print("Invalid input. Must be a positive integer greater than 0.\n"
                    + "Select which transaction item to remove: ");
            }
        } while (input <= 0);
        if (!account.removeTransaction(input - 1)) {
            System.out.println("Error: unable to remove that transaction");
        }
    }
    
    /**
     * Method removeAllTrans()
     * 
     * calls on the account method clearTransactions()
     * Displays a message to the user to let them know that something has been done
     */
    public static void removeAllTrans() {
        account.clearTransactions();
        System.out.println("All transactions have been removed.");
    }
    
    /**
     * Method displayAcctInfo()
     * Returns the details of the account,
     */
    public static void displayAcctInfo() {
        System.out.println("Account info: \n" + account);
    }
    
    /**
     * Method listAllTrans()
     * calls on the method getAllTransactions and displays them, seperated by a line space
     */
    public static void listAllTrans() {
        System.out.println("All transactions:\n" + account.getAllTransactions());
    }
    
    /**
     * Method showCurrentBalance()
     * Calls on the method getCurrentBalance to display the current balance
     */
    public static void showCurrentBalance() {
        System.out.println("Current balance: " + account.getCurrentBalance());
    }
}