
/**
 * Transaction Class. Used to keep track of a transaction inside an account.
 * Containing three fields, and able to display details of the transaction
 * Will not contain any set methods
 * 
 * DO NOT PUT ANY I/O IN THIS CLASS. NO SCANNER OR SYSTEM.OUT.PRINTLN IN THIS CLASS
 * 
 * @author Andrew Beaulieu 
 * @version 2016.11.07
 */

import java.*;

public class Transaction
{
    // instance variables - replace the example below with your own
    private String dateOfTransaction;
    private String typeOfTransaction;
    private double amountOfTransaction;

    /**
     * Constructor for objects of class Transaction
     * Takes an arguement to initialize each of the three fields listed at
     * top of class
     */
    public Transaction(String initDate, String initTransaction, double initAmount)
    {
        // initialise instance variables
        dateOfTransaction = initDate;
        typeOfTransaction = initTransaction;
        amountOfTransaction = initAmount;
    }

    /**
     * toString Method
     * Creates a display of the three fields
     * 
     * @param      none
     * @return     dateOfTransaction + blank + typeOfTransaction + blank
     *              + amountOfTransaction
     */
    @Override
    public String toString()
    {
        // put your code here
        String report;
        
        report = dateOfTransaction;
        report = report + "   ";
        report = report + typeOfTransaction;
        report = report + "   ";
        report = report + amountOfTransaction;
        
        return report;
    }
    
    public String getDate(){
        return dateOfTransaction;
    }
    
    public String getType(){
        return typeOfTransaction;
    }
    
    public double getAmount(){
        return amountOfTransaction;
    }
}
