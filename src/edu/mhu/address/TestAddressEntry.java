package edu.mhu.address;

/**
 * @author Margaret Hu
 * @since February 2021
 *
 * This class is used to test the AddressEntry class.
 */
public class TestAddressEntry {
    public TestAddressEntry() {}

    private void printFields(AddressEntry entry) {
        System.out.println(" First Name: " + entry.getFirstName());
        System.out.println(" Last Name: " + entry.getLastName());
        System.out.println(" Street: " + entry.getStreet());
        System.out.println(" City: " + entry.getCity());
        System.out.println(" State: " + entry.getState());
        System.out.println(" Zip: " + entry.getZip());
        System.out.println(" Email: " + entry.getEmail());
        System.out.println(" Phone: " + entry.getPhone());
    }

    public void runTest() {
        String[] test1 = {"Lynne", "Grewe", "123 3rd Ave", "Hayward", "CA", "28666", "lynne.grewe@csueastbay.edu", "510-885-4167"};
        String[] test2 = {"Butch", "Grewe", "Bay Avenue", "Capitoal", "CA", "99999", "bg@gmail.com", "415-389-1239"};
        String[][] tests = {test1, test2};
        for (String[] t : tests) {
            String fn = t[0];
            String ln = t[1];
            String addr = t[2];
            String c = t[3];
            String st = t[4];
            Integer z = Integer.valueOf(t[5]);
            String e = t[6];
            String p = t[7];
            AddressEntry entry = new AddressEntry(fn, ln, addr, c, st, z, e, p);

            System.out.println("Testing " + entry);
            printFields(entry);

            System.out.println("Setting to upper case");
            entry.setFirstName(fn.toUpperCase());
            entry.setLastName(ln.toUpperCase());
            entry.setStreet(addr.toUpperCase());
            entry.setCity(c.toUpperCase());
            entry.setState(st.toUpperCase());
            entry.setZip(z+1);
            entry.setEmail(e.toUpperCase());
            entry.setPhone(p.toUpperCase());
            printFields(entry);
        }
    }
}
