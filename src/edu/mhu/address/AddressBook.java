package edu.mhu.address;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class AddressBook {
    /**
     * The data structure that will hold the data for the address book.
     */
    private TreeMap<String, TreeSet<AddressEntry>> addressDatabase;

    /**
     * Constructor for AddressBook. Creates an empty TreeMap.
     */
    public AddressBook() {
        System.out.println("Constructing AddressBook");
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
            set = new TreeSet<>((a,b) -> a.getFirstName().compareTo(b.getFirstName()));
            addressDatabase.put(lastName, set);
        }
        set.add(e);
    }

    /**
     * Removes selected entries from AddressBook.
     * @param entry
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
     * Gives an array of entries to chose
     * @param lastName
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
     *
     * @param startOf_lastName is a string which contains either a full last name or the first consecutive characters
     *                         of a last name in an AddressEntry
     */
    public void find(String startOf_lastName) {
        SortedMap<String, TreeSet<AddressEntry>> subSection;
        subSection = addressDatabase.subMap(startOf_lastName, startOf_lastName + "~"/*last char*/);
        if (subSection.size() > 0) {
            System.out.println("The following " + subSection.size() + " entries were found in the address book " +
                    "for a last name starting with \"" + startOf_lastName + "\"");
            int i = 1;
            for(Map.Entry<String, TreeSet<AddressEntry>> iter : subSection.entrySet()) {
                for(AddressEntry e : iter.getValue()) {
                    System.out.println(i + ": " + e);
                    i++;
                }
            }
            return;
        }
        System.out.println("There were no entries were found in the address book " +
                "for a last name starting with \"" + startOf_lastName + "\"");
    }
}
