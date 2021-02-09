package edu.mhu.address;

public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String phone;
    private String email;

    public AddressEntry () {
        System.out.println("Address entry created");
        firstName = "John";
        lastName = "Doe";
        street = "Maple";
        city = "Fremont";
        state = "CA";
        zip = 94538;
        phone = "(510)123-4567";
        email = "jd@gmail.com";
    }

    public AddressEntry (String fn, String ln, String strt, String c, String stt, int z, String p, String e) {
        firstName = fn;
        lastName = ln;
        street = strt;
        city = c;
        state = stt;
        zip = z;
        phone = p;
        email = e;
    }

    public String toString() {
        String str = "\n";
        str += "\t" + firstName + "\n";
        str += "\t" + lastName + "\n";
        str += "\t" + street + "\n";
        str += "\t" + city + "\n";
        str += "\t" + state + "\n";
        str += "\t" + zip + "\n";
        str += "\t" + phone + "\n";
        str += "\t" + email + "\n";
        return str;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
