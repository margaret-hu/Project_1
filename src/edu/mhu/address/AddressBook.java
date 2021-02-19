package edu.mhu.address;

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<AddressEntry> addressEntryList;

    /**
     * Constructor for AddressBook. Creates an empty array list.
     */
    public AddressBook() {
        System.out.println("Constructing AddressBook");
        addressEntryList = new ArrayList<>();
    }

    /**
     * Add an entry to the list.
     * @param e Add to addressEntryList.
     */
    public void add(AddressEntry e) {
        addressEntryList.add(e);
    }

    /**
     * Prints all address entries present in the list.
     */
    public void list() {
        for (AddressEntry e : addressEntryList) {
            System.out.println(e);
        }
    }
}
