// Author: Devin Wingo
// Description: CS 320 - Project 1 - Contact Model

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Constructor for Contact object
    public Contact(String contactId,
                   String firstName,
                   String lastName,
                   String phoneNumber,
                   String address) {

        // Constructor argument validations
        // contactId is not null and no more than 10 characters long
        if(contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contactId.");
        }

        // firstName is not null and no more than 10 characters long
        if(firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid firstName.");
        }

        // lastName is not null and no more than 10 characters long
        if(lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid lastName.");
        }

        // phoneNumber is not null and is 10 digits long
        if(phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phoneNumber.");
        }

        // is not null and no more than 30 characters long
        if(address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address.");
        }

        // Set values for Contact
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // getters for Contact
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // setters for Contact w/ argument validation
    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid firstName.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid lastName.");
        }
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phoneNumber.");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        if(address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address.");
        }
        this.address = address;
    }
}
