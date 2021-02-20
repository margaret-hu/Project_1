package edu.mhu.address;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AddressBookApplication {
    // Class variable
    private static AddressBook ab = new AddressBook();

    public static void main(String[] args) throws IOException {
        testIndividualClass();
        /*
        initAddressBookExercise(ab);

        //init("/home/margaret/AddressInputDataFile.txt", ab);

        // Call a listing on ab to see the new entries generated from init
        ab.list();
         */
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

    /**
     *
     * @param filename The file to be read.
     * @param ab The class variable to pass in.
     * @throws IOException
     */
    public static void init(String filename, AddressBook ab) throws IOException {
        FileInputStream file = null;
        try {
            file = new FileInputStream(filename);
            Scanner scanner = new Scanner(file);

            // Create while loop to read file
            while (scanner.hasNext()) {
                // Read in first name
                String fn = scanner.nextLine();

                // Read in last name
                String ln = scanner.nextLine();

                // Read in street
                String street = scanner.nextLine();

                // Read in city
                String c = scanner.nextLine();

                // Read in state
                String state = scanner.nextLine();

                // Read in zip
                Integer z = Integer.valueOf(scanner.nextLine());

                // Read in email
                String e = scanner.nextLine();

                // Read in phone
                String p = scanner.nextLine();

                // Create AddressEntry using read in information and add it to the AddressBook
                AddressEntry entry = new AddressEntry(fn, ln, street, c, state, z, p, e);
                ab.add(entry);
            } // end of while loop
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (file != null) file.close();
        }
    }
}
