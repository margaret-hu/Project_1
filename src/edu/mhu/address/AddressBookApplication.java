package edu.mhu.address;

import java.io.IOException;
import java.util.Scanner;

import static edu.mhu.address.Menu.prompt_All;

/**
 * @author Margaret Hu
 * @since February 2021
 *
 * This class is used to add, delete, and query data from an address book.
 */
public class AddressBookApplication {
    // Class variable
    private static final AddressBook ab = new AddressBook();

    public static void main(String[] args) throws IOException {
        //initAddressBookExercise();
        //testIndividualClass();
        runInteractive();
    }

    /**
     * Prompts user for various commands to modify and display the AddressBook
     * @throws IOException
     */
    private static void runInteractive() throws IOException {
        Menu menu = new Menu();
        Scanner input = new Scanner(System.in);
        while (true) {
            menu.display();
            System.out.print("> ");
            String choice = input.nextLine();
            if (choice.equals("a")) {
                System.out.println("Enter in FileName:");
                System.out.print("> ");
                String filename = input.nextLine();
                ab.readFromFile(filename);
                System.out.println("Read in new Addresses, successfully loaded");
            } else if (choice.equals("b")) {
                AddressEntry entry = prompt_All();
                ab.add(entry);
                System.out.println("Thank you the following contact has been added to your address book:");
                System.out.println(entry);
            } else if (choice.equals("c")) {
                System.out.println("Enter in Last Name of contact to remove:");
                System.out.print("> ");
                String lastName = input.nextLine();
                AddressEntry[] choices = ab.remove(lastName);
                System.out.println("The following " + choices.length +
                        " entries were found in the address book, select number\nof entry you wish to remove:");
                int i = 1;
                for (AddressEntry e : choices) {
                    System.out.println(i + ": " + e);
                    i++;
                }
                System.out.print("> ");
                int num = Integer.valueOf(input.nextLine());
                System.out.println("Hit y to remove the following entry or n to return to main menu:");
                AddressEntry e = choices[num-1];
                System.out.println(e);
                System.out.print("> ");
                String ans = input.nextLine();
                if (ans.equals("y")) {
                    System.out.println("You have successfully removed the " +
                            e.getFirstName() + " " + e.getLastName() + " contact");
                    ab.remove(e);
                }
            } else if (choice.equals("d")) {
                System.out.println("Enter in all or the beginning of the Last Name of the contact you wish to find:");
                System.out.print("> ");
                String ans = input.nextLine();
                ab.find(ans);
            } else if (choice.equals("e")) {
                ab.list();
            } else if (choice.equals("f")) {
                break;
            } else {
                System.out.println("Error: " + choice + " is not a valid selection.");
            }
        }
    }

    private static void testIndividualClass() {
        System.out.println("Testing AddressEntry");
        System.out.println("============================================================");
        AddressEntryTest aeTest = new AddressEntryTest();
        aeTest.runTest();
        System.out.println("Testing AddressBook");
        System.out.println("============================================================");
        AddressBookTest abTest = new AddressBookTest();
        abTest.runTest();
    }

    private static void initAddressBookExercise(AddressBook a) {
        System.out.println("Will add 2 entry into address book a");

        AddressEntry e1 = new AddressEntry("Margaret", "Hu", "Mallard", "Fremont", "CA", 94555, "(510)384-9112", "mhu11@gmail.com");

        AddressEntry e2 = new AddressEntry();
        e2.setFirstName("John");
        e2.setLastName("Doe");
        e2.setStreet("Maple");
        e2.setCity("Fremont");
        e2.setState("CA");
        e2.setZip(94538);
        e2.setPhone("(510)123-4567");
        e2.setEmail("jd@gmail.com");

        ab.add(e1);
        ab.add(e2);

        ab.list();
    }
}
