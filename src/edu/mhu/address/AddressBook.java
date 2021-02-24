package edu.mhu.address;

import java.io.*;
import java.util.*;

/**
 * @author Margaret Hu
 * @since February 2021
 *
 * This class represents and contains a possibly ever growing and/or shrinking "list" of AddressEntries.
 * It allows for various operations such as search/find, addition and removal of AddressEntries.
 */
public class AddressBook {
    /**
     * The data structure that will hold the data for the address book.
     */
    private final TreeMap<String, TreeSet<AddressEntry>> addressDatabase;

    /**
     * Constructor for AddressBook. Creates an empty TreeMap.
     */
    public AddressBook() {
        //System.out.println("Constructing AddressBook");
        addressDatabase = new TreeMap<>();
    }

    /**
     * Prints all address contained in AddressBook.
     */
    public void list() {
        for (Map.Entry<String, TreeSet<AddressEntry>> iter : addressDatabase.entrySet()) {
            for (AddressEntry e : iter.getValue()) {
                System.out.println(e);
            }
        }
    }

    /**
     * Removes selected entry from AddressBook.
     * @param entry is the list of candidates for removal
     */
    public void remove(AddressEntry entry) {
        if (entry == null) return;
        String lastName = entry.getLastName();
        if (!addressDatabase.containsKey(lastName)) return;
        TreeSet<AddressEntry> set = addressDatabase.get(lastName);
        if (!set.contains(entry)) return;
        set.remove(entry);
        if (set.size() == 0) addressDatabase.remove(lastName);
    }

    /**
     * Gives an array of possible entries to remove
     * @param lastName is the last name (or some initial consecutive characters)
     *                 of the person contained in the AddressEntry
     * @return a list of candidates for removal
     */
    public AddressEntry[] remove(String lastName) {
        if (!addressDatabase.containsKey(lastName)) return null;
        TreeSet<AddressEntry> set = addressDatabase.get(lastName);
        int size = set.size();
        AddressEntry[] ans = new AddressEntry[size];
        int i = 0;
        // Go through each AddressEntry with the same last name
        for (AddressEntry e : set) {
            ans[i++] = e;
        }
        return ans;
    }

    /**
     * Add an entry to AddressBook.
     * @param e is an instance of AddressEntry to add to the AddressBook
     */
    public void add(AddressEntry e) {
        String lastName = e.getLastName();
        TreeSet<AddressEntry> set;
        // Check to see if the key already exists
        if (addressDatabase.containsKey(lastName)) {
            // Add the entry to the correct TreeSet.
            set = addressDatabase.get(lastName);
        } else {
            // Create a new TreeSet to contain the entry.
            set = new TreeSet<>(Comparator.comparing(AddressEntry::getFirstName));
            addressDatabase.put(lastName, set);
        }
        set.add(e);
    }

    /**
     * Reads in address entries from a text file and adds them to the AddressBook
     * @param filename is a string which is the name of a text file that contains address Entry data
     */
    public void readFromFile(String filename) throws IOException {
        FileInputStream file = null;
        try {
            file = new FileInputStream(filename);
            Scanner scanner = new Scanner(file);

            // Create while loop to read file
            while (scanner.hasNext()) {
                String fn = scanner.nextLine(); // Read in first name
                String ln = scanner.nextLine(); // Read in last name
                String street = scanner.nextLine(); // Read in street
                String c = scanner.nextLine(); // Read in city
                String state = scanner.nextLine(); // Read in state
                Integer z = Integer.valueOf(scanner.nextLine()); // Read in zip
                String e = scanner.nextLine(); // Read in email
                String p = scanner.nextLine(); // Read in phone

                // Create AddressEntry using read in information and add it to the AddressBook
                AddressEntry entry = new AddressEntry(fn, ln, street, c, state, z, p, e);
                this.add(entry);
            } // end of while loop
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (file != null) file.close();
        }
    }

    /**
     * Displays one or multiple address entries from the AddressBook
     * @param startOf_lastName is a string which contains either a full last name
     *                         (or some initial consecutive characters) of a last name in an AddressEntry
     */
    public void find(String startOf_lastName) {
        SortedMap<String, TreeSet<AddressEntry>> subSection;
        subSection = addressDatabase.subMap(startOf_lastName, startOf_lastName + "~" /* last char */);
        if (subSection.size() > 0) {
            int i = 0;
            String temp = "";
            // Computes the total number of Address entries in subSection
            for(Map.Entry<String, TreeSet<AddressEntry>> iter : subSection.entrySet()) {
                for(AddressEntry e : iter.getValue()) {
                    temp += ++i + ": " + e;
                }
            }
            System.out.println("The following " + i + " entries were found in the address book " +
                    "for a last name starting with \"" + startOf_lastName + "\"");
            System.out.println(temp);
        }
        System.out.println("There were no entries were found in the address book " +
                "for a last name starting with \"" + startOf_lastName + "\"");
    }
}
