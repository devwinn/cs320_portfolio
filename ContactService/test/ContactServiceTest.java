// Author: Devin Wingo
// Description: CS 320 - Project 1 - Contact Service Test

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactServiceTest {
    // Test adding Contact object to contactList
    @Test
    void testAddContact() {
        ContactService testService = new ContactService();
        Contact contact = new Contact("TestId123",
                "Jayden",
                "Daniels",
                "1234567890",
                "1900 Yellow Brick Rd");

        testService.addContact(contact);

        Contact testContact = testService.getContact(contact.getContactId());

        assertEquals("TestId123", testContact.getContactId());
    }

    // Test Contact object cannot be null
    @Test
    void testAddContactNull() {
        ContactService testService = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            testService.addContact(null);
        });
    }

    // Test contactId is unique
    @Test
    void testUniqueId() {
        ContactService testService = new ContactService();
        Contact contact1 = new Contact("TestId123",
                "Jaxon",
                "Dart",
                "1234567890",
                "1900 Yellow Brick Rd");

        Contact contact2 = new Contact("TestId123",
                "Dak",
                "Prescott",
                "1234567890",
                "1900 Yellow Brick Rd");

        testService.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () ->
                testService.addContact(contact2));
    }

    // Test delete Contact object using contactId
    @Test
    void testDeleteContact() {
        ContactService testService = new ContactService();
        Contact contact = new Contact("TestId123",
                "Joe",
                "Burrow",
                "1234567890",
                "1900 Yellow Brick Rd");

        testService.addContact(contact);
        testService.deleteContact(contact.getContactId());

        assertThrows(IllegalArgumentException.class, () ->
        {testService.getContact(contact.getContactId());
        });
    }

    // Test deleting contact id that is not in service
    @Test
    void testDeleteContactIdNotFound() {
        ContactService testService = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            testService.deleteContact("TestId123");
        });
    }

    // Test update firstName using contactId
    @Test
    void testUpdateFirstName() {
        ContactService testService = new ContactService();
        Contact contact = new Contact("TestId123",
                "Lamar",
                "Jackson",
                "1234567890",
                "1900 Yellow Brick Rd");

        testService.addContact(contact);
        testService.updateFirstName("TestId123", "Bo");

        Contact testContact = testService.getContact(contact.getContactId());

        assertEquals("Bo", testContact.getFirstName());
    }

    // Test update lastName using contactId
    @Test
    void testUpdateLastName() {
        ContactService testService = new ContactService();
        Contact contact = new Contact("TestId123",
                "Carson",
                "Wentz",
                "1234567890",
                "1900 Yellow Brick Rd");

        testService.addContact(contact);
        testService.updateLastName("TestId123", "Palmer");

        Contact testContact = testService.getContact(contact.getContactId());

        assertEquals("Palmer", testContact.getLastName());
    }

    // Test update phoneNumber using contactId
    @Test
    void testUpdatePhoneNumber() {
        ContactService testService = new ContactService();
        Contact contact = new Contact("TestId123",
                "Jordan",
                "Love",
                "1234567890",
                "1900 Yellow Brick Rd");

        testService.addContact(contact);
        testService.updatePhoneNumber("TestId123", "0987654321");

        Contact testContact = testService.getContact(contact.getContactId());

        assertEquals("0987654321", testContact.getPhoneNumber());
    }

    // Test update address using contactId
    @Test
    void testUpdateAddress() {
        ContactService testService = new ContactService();
        Contact contact = new Contact("TestId123",
                "Jaylen",
                "Hurts",
                "1234567890",
                "1900 Yellow Brick Rd");

        testService.addContact(contact);
        testService.updateAddress("TestId123", "4 Privet Dr");

        Contact testContact = testService.getContact(contact.getContactId());

        assertEquals("4 Privet Dr", testContact.getAddress());
    }
}
