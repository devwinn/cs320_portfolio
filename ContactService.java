// Author: Devin Wingo
// Description: CS 320 - Project 1 - Contact Service

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    // ArrayList for storing Contact objects
    private final List<Contact> contactList = new ArrayList<>();

    // Get Contact object using contactId
    public Contact getContact(String contactId) {
        // Find Contact using contactId
        for(Contact contact: contactList) {
            if(contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        // Throw exception if contactId is not found
        throw new IllegalArgumentException("contactId not found.");
    }

    // Add Contact object to contactList
    public void addContact(Contact newContact) {
        // Check Contact object is not null
        if(newContact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        // Check contactList for matching contactId
        for(Contact contact : contactList) {
            // contactId must be unique
            if(contact.getContactId().equals(newContact.getContactId())) {
                throw new IllegalArgumentException("Invalid contactId, contactId already exists.");
            }
        }

        // Add Contact when contactId is unique
        contactList.add(newContact);
    }

    // Delete Contact object using contactId
    public void deleteContact(String contactId) {
        Contact contact = getContact(contactId);
        contactList.remove(contact);
    }

    // Update firstName using contactId
    public void updateFirstName(String contactId, String name) {
        Contact contact = getContact(contactId);
        contact.setFirstName(name);
    }

    // Update lastName using contactId
    public void updateLastName(String contactId, String name) {
        Contact contact = getContact(contactId);
        contact.setLastName(name);
    }

    // Update phoneNumber using contactId
    public void updatePhoneNumber(String contactId, String phoneNumber) {
        Contact contact = getContact(contactId);
        contact.setPhoneNumber(phoneNumber);
    }

    // Update address using contactId
    public void updateAddress(String contactId, String address) {
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }
}
