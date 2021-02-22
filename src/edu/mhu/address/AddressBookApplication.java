package edu.mhu.address;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AddressBookApplication {
    // Class variable
    private static AddressBook ab = new AddressBook();

    public static void main(String[] args) throws IOException {
        //testIndividualClass();
        runInteractive();
        /*
        initAddressBookExercise(ab);

        //init("/home/margaret/AddressInputDataFile.txt", ab);

        // Call a listing on ab to see the new entries generated from init
        ab.list();
         */
    }

    private static void runInteractive() throws IOException {
        Menu menu = new Menu();
        Scanner input = new Scanner(System.in);
        while (true) {
            menu.display();
            String choice = input.nextLine();
            if (choice.equals("a")) {
                System.out.println("> a");
                System.out.println("Enter in FileName:");
                String filename = input.nextLine();
                System.out.println("> " + filename);
                ab.readFromFile(filename);
            } else if (choice.equals("b")) {
                System.out.println("> b");
                String firstName = Menu.prompt_FirstName();
                System.out.println("> " + firstName);
                String lastName = Menu.prompt_LastName();
                System.out.println("> " + lastName);
                String street = Menu.prompt_Street();
                System.out.println("> " + street);
                String city = Menu.prompt_City();
                System.out.println("> " + city);
                String state = Menu.prompt_State();
                System.out.println("> " + state);
                int zip = Menu.prompt_Zip();
                System.out.println("> " + zip);
                String phone = Menu.prompt_Telephone();
                System.out.println("> " + phone);
                String email = Menu.prompt_Email();
                System.out.println("> " + email);
            } else if (choice.equals("c")) {
                ;
            } else if (choice.equals("d")) {
                ;
            } else if (choice.equals("e")) {
                ;
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
        TestAddressEntry aetest = new TestAddressEntry();
        aetest.runTest();
        System.out.println("Testing AddressBook");
        System.out.println("============================================================");
        TestAddressBook abtest = new TestAddressBook();
        abtest.runTest();
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

        a.add(e1);
        a.add(e2);
        //a.list();
    }
}
