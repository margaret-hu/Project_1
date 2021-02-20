package edu.mhu.address;

public class AddressEntry {
    // Instance variables
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private String phone;
    private String email;

    /**
     * Default constructor
     */
    public AddressEntry () {
        System.out.println("Address entry created");
        firstName = "";
        lastName = "";
        street = "";
        city = "";
        state = "";
        zip = 0;
        phone = "";
        email = "";
    }

    /**
     * The constructor which builds the entry from the given parameters.
     * @param firstName
     * @param lastName
     * @param street
     * @param city
     * @param state
     * @param zip
     * @param phone
     * @param email
     */
    public AddressEntry (String firstName, String lastName, String street, String city, String state, Integer zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Prints out the components of the address entry in a nicely formatted way.
     * @return A formatted String.
     */
    @Override
    public String toString() {
        String str = "\n";
        str += "\t" + firstName + " " + lastName + "\n";
        str += "\t" + street + "\n";
        str += "\t" + city + ", " + state + " " + zip.intValue() + "\n";
        str += "\t" + phone + "\n";
        str += "\t" + email + "\n";
        return str;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return zip
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * @param zip
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
