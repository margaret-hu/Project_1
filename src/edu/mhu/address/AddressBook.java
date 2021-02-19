package edu.mhu.address;

import java.util.*;

public class AddressBook {
    private TreeMap<String, TreeSet<AddressEntry>> addressDatabase;

    /**
     * Constructor for AddressBook. Creates an empty array list.
     */
    public AddressBook() {
        System.out.println("Constructing AddressBook");
        addressDatabase = new TreeMap<>();
    }

    /**
     * Add an entry to the database.
     * @param e Add to addressDatabase.
     */
    public void add(AddressEntry e) {
        String lastName = e.getLastName();
        TreeSet<AddressEntry> set;
        // Check if last name is already in the database
        if (addressDatabase.containsKey(lastName)) {
            // Add the entry to the TreeSet that already have entries with same last name
            set = addressDatabase.get(lastName);
        } else {
            // Create a TreeSet that will hold all entries with same last name
            set = new TreeSet<>((a,b) -> a.getFirstName().compareTo(b.getFirstName()));
            addressDatabase.put(lastName, set);
        }
        set.add(e);
    }

    /**
     * Removes
     * @param lastName
     * @return a list of candidates for removal
     */
    public AddressEntry[] remove(String lastName) {
        if (!addressDatabase.containsKey(lastName))
            return null;
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
     * Prints all address entries present in the list.
     */
    public void list() {
        /*
        for (AddressEntry e : addressEntryList) {
            System.out.println(e);
        }
         */
    }
}
