package edu.mhu.address;

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<AddressEntry> addressEntryList;

    public AddressBook() {
        System.out.println("Constructing AddressBook");
        addressEntryList = new ArrayList<>();
    }

    public void add(AddressEntry e) {
        addressEntryList.add(e);
    }

    public void list() {
        for (AddressEntry e : addressEntryList) {
            System.out.println(e);
        }
    }
}
