package edu.mhu.address;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Margaret Hu
 * @since February 2021
 *
 * This class is used to display menu options to the user.
 */
public class Menu {
    /**
     * Gets input from the user
     */
    private final static Scanner in = new Scanner(System.in);

    public Menu() {}

    /**
     * prompt_FirstName  generates a standard output prompt for the First Name to be entered
     * @return  a String which represents a person's First Name in an AddressEntry
     */
    public static String prompt_FirstName()
    {
        System.out.println("First Name:");
        System.out.print("> ");
        return in.nextLine();
    }

    /**
     * prompt_LastName  generates a standard output prompt for the Last Name to be entered
     * @return  a String which represents a person's Last Name in an AddressEntry
     */
    public static String prompt_LastName()
    {
        System.out.println("Last Name:");
        System.out.print("> ");
        return in.nextLine();
    }

    /**
     * prompt_Street  generates a standard output prompt for the Street to be entered
     * @return  a String which represents a person's Street in an AddressEntry
     */
    public static String prompt_Street()
    {
        System.out.println("Street:");
        System.out.print("> ");
        return in.nextLine();
    }

    /**
     * prompt_City  generates a standard output prompt for the City to be entered
     * @return  a String which represents a person's City in an AddressEntry
     */
    public static String prompt_City()
    {
        System.out.println("City:");
        System.out.print("> ");
        return in.nextLine();
    }

    /**
     * prompt_State  generates a standard output prompt for the State to be entered
     * @return  a String which represents a person's in an AddressEntry
     */
    public static String prompt_State()
    {
        System.out.println("State:");
        System.out.print("> ");
        return in.nextLine();
    }

    /**
     * prompt_Zip  generates a standard output prompt for the Zip to be entered
     * @return  an int which represents a person's zip in an AddressEntry
     */
    public static int prompt_Zip()
    {
        try {
            Scanner Keyboard = new Scanner(System.in);
            System.out.println("Zip: ");
            System.out.print("> ");
            return Keyboard.nextInt();
        }
        catch(InputMismatchException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * prompt_Telephone  generates a standard output prompt for the Telephone to be entered
     * @return  a String which represents a person's in an AddressEntry
     */
    public static String prompt_Telephone()
    {
        System.out.println("Telephone:");
        System.out.print("> ");
        return in.nextLine();
    }

    /**
     * prompt_Email  generates a standard output prompt for the Email to be entered
     * @return  a String which represents a person's in an AddressEntry
     */
    public static String prompt_Email()
    {
        System.out.println("Email:");
        System.out.print("> ");
        return in.nextLine();
    }

    /**
     * prompt_All  instantiates and returns a new AddressEntry with values that are specified by the user with calls to all of the prompt methods
     * @return  an AddressEntry which contains information specified by user
     */
    public static AddressEntry prompt_All() {
        return new AddressEntry(prompt_FirstName(), prompt_LastName(), prompt_Street(),
                prompt_City(), prompt_State(), prompt_Zip(), prompt_Telephone(),
                prompt_Email());
    }

    /**
     * Prints out a menu which prompts user for selection of operation to be performed on AddressBook
     */
    public static void display() {
        System.out.println( "*************************" +
                "\nPlease enter your menu selection" +
                "\na) Loading From File" +
                "\nb) Addition" +
                "\nc) Removal" +
                "\nd) Find" +
                "\ne) Listing" +
                "\nf) Quit" +
                "\n*************************");
    }
}
