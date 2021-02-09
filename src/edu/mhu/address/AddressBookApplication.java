package edu.mhu.address;

public class AddressBookApplication {
    public static void main(String[] args) {
        System.out.println("Hello");
        AddressBook ab = new AddressBook();
        initAddressBookExercise(ab);
    }
    private static void initAddressBookExercise(AddressBook a) {
        System.out.println("Will add 2 entry into address book a");
        AddressEntry e1 = new AddressEntry();
        AddressEntry e2 = new AddressEntry("Margaret", "Hu", "Mallard", "Fremont", "CA", 94555, "(510)384-9112", "mhu11@gmail.com");
        a.add(e1);
        a.add(e2);
        a.list();
    }
}
