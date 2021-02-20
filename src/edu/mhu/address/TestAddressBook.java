package edu.mhu.address;

public class TestAddressBook {
    public TestAddressBook() {}
    public void runTest() {
        AddressEntry e1 = new AddressEntry("David", "Hu", "4770 Mallard", "Fremont", "CA", 94555, "(510)935-9292", "hu@ieee.org");
        AddressEntry e2 = new AddressEntry("Veronica", "Hu", "4770 Mallard", "Fremont", "CA", 94555, "(510)518-7091", "veronica.sy.hu@gmail.com ");
        AddressEntry e3 = new AddressEntry("Diana", "Huang", "4770 Mallard", "Fremont", "CA", 94555, "(510)709-5158", "diana.w.hu@gmail.com ");
        AddressEntry e4 = new AddressEntry("Iliana", "Bicakci", "1 Harpst St", "Arcata", "CA", 95521, "(510)912-6169", "iliana_b@outlook.com");
        AddressBook ab = new AddressBook();
        AddressEntry[][] tests = {{e1, e2, e3, e4}, {e2, e3, e1, e4}, {e4, e3, e2, e1}};
        for (AddressEntry[] ts : tests) {
            for (int i = 0; i < ts.length; i++) {
                if (i == 0) {
                    ab.add(ts[i]);
                } else if (i == 1) {
                    ab.add(ts[i]);
                    ab.list();
                } else if (i == 2) {
                    ab.add(ts[i]);
                    ab.find("Hu");
                    ab.remove(ts[1]);
                } else if (i == 3) {
                    ab.list();
                    ab.remove(ts[2]);
                    ab.list();
                }
            }
            for (AddressEntry e : ts) {
                ab.remove(e);
            }
        }
        /*AddressEntry[] tests = {e2, e1, e3, e4};
        for (AddressEntry e : tests) {
            ab.add(e);
        }
        AddressEntry[] arr = ab.remove("Hu");
        ab.find("Hu");
        for (AddressEntry e : tests) {
            ab.list();
            ab.remove(e);
            System.out.println("Removing " + e.getFirstName());
        }
        ab.remove(e4);*/
    }
}
