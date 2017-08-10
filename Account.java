
/**
 * Account class. Holds 5 fields. Provides all methods to be able to CRUD (Create, Read, Update,
 * Delete) an Account Object. 
 * 
 * @author Andrew Beaulieu
 * @version 11152016
 */
import java.*;
import java.util.Arrays;

public class Account
{
    // instance variables - replace the example below with your own
    private String bankName;
    private String typeOfAccount;
    private String accountNumber;
    private double initialBalance;
    private Transaction[] listOfTransactions;
    private int numberOfTransactions;
    
    /**
     * Constructor for objects of class Account
     * Initializes fields: initBankName, initTypeAccount, initAccountNumber, initStartBalance, size)
     * fields are received from AccountApplication class from the user.
     */
    public Account(
        String initBankName,
        String initTypeAccount,
        String initAccountNumber, 
        double initStartBalance,
        int size
        )
    {
        // initialise instance variables
        bankName = initBankName;
        typeOfAccount = initTypeAccount;
        accountNumber = initAccountNumber;
        initialBalance = initStartBalance;
        listOfTransactions = new Transaction[size];
        numberOfTransactions = 0;
    }

    
    public Transaction[] toArray() {
       Transaction[] temp = new Transaction[numberOfTransactions];
        
       for (int i=0; i < numberOfTransactions; i++) {
            temp[i] = listOfTransactions[i];
       }
        
       return temp;
    }
    
    
    /**
     * getBankName()
     * Returns the name of the bank
     */
    public String getBankName() {
        // put your code here
        return bankName;
    }
    
    /**
     * getTypeAccount()
     * Returns the name of the type of the account
     */
    public String getTypeAccount() {
        return typeOfAccount;
    }
    
    /**
     * getAccountNumber()
     * Returns the account number. The account number is a String
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    
    /**
     * getInitBalance()
     * Returns the starting balance of the account
     */
    public double getInitBalance() {
        return initialBalance;
    }
    
    /**
     * Method addTransaction()
     * @param Transaction type
     * adds the transaction to the listOfTransactions array
     * if successful, returns true. If failed, returns false
     */
    
    public boolean addTransaction(Transaction newTransaction){
        boolean result = false;
        
        if (numberOfTransactions < listOfTransactions.length) 
        {
            listOfTransactions[numberOfTransactions] = newTransaction;
            numberOfTransactions++;
            result = true;
        }
        
        return result;
    }
    
    /**
     * Method clearTransactions()
     * Researched through Stack Overflow
     * Taking all elements in the array, and clearing them by setting them to 'null'
     * Then resetting the numberOfTransactions back to zero
     */
    public void clearTransactions(){
        Arrays.fill(listOfTransactions, null);
        numberOfTransactions = 0;
    }
    
    
    /**
     * Method removeTransaction()
     * Researched through MSU tutoring center
     * @param id
     * Decrementing the numberOfTransactions
     * Looks for the object at index 'id' and removing it.
     * Note: result is that last item in the list is moved into that deleted index
     */
    public boolean removeTransaction(int id){
        boolean result = false;
        if (id >= 0 && id < numberOfTransactions) {
            Transaction temp = listOfTransactions[--numberOfTransactions];
            listOfTransactions[id] = temp;
            result = true;
        }
        return result;
    }
    
    /**
     * Method getAllTransactions()
     * Checks to make sure that the numberOfTransactions is not already 0
     * 
     * Loops through the contents of each index of the array listOfTransactions, and using a line
     * space to seperate them
     */
    public String getAllTransactions(){
        if (numberOfTransactions == 0) {
            return null;
        }
        String result = "";
        for (int i = 0; i < numberOfTransactions; i++) {
            result += listOfTransactions[i] + "\n";
        }

        return result;
    }
    
    /**
     * Method getAmounts()
     * @param input
     * Research through MSU tutoring center
     * 
     * Additional method to reduce repeated code for the getCurrentBalance() method
     * Uses a loop to search the entire listOfTransactions array for only contents that have the
     * type of transaction matching the input. Then the loop adds the results of all of these types
     * together and returning a result.
     */
    private double getAmounts(String input) {
        double result = 0.0;
        for (int i = 0; i < numberOfTransactions; i++) {
            if (listOfTransactions[i].getType().equals(input)) result += listOfTransactions[i].getAmount();
        }
        return result;
    }
    
    /**
     * Method getCurrentBalance()
     * Research through MSU tutoring center
     * 
     * establishes local variables: deposits, withdrawals, interests, serviceCharges
     * Calls on the method getAmounts to add those types of transactions in the listOfTransactions
     * array. Then adds all of these together and returns the value as a double.
     */
    public double getCurrentBalance() {
        double deposits, withdrawals, interests, serviceCharges;
        deposits = getAmounts("deposit");
        withdrawals = getAmounts("withdrawal");
        interests = getAmounts("interest payment");
        serviceCharges = getAmounts("service charge");
        return initialBalance + deposits - withdrawals + interests - serviceCharges;
    }
    
    /**
     * Method toString()
     * Override part added through advice from MSU tutoring center
     * Override is because instead of the standard toString method, a custom one is made for this
     * class
     * 
     * Creates a customized toString method that will return the Accound variables:
     * bankName + accountNumber + typeOfAccount
     */
    @Override
    public String toString() {
        return bankName + " " + accountNumber + " " + typeOfAccount;
    }
}
