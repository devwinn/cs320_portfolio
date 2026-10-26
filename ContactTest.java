// Author: Devin Wingo
// Description: CS 320 - Project 1 - Contact Model Test

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactTest {
    // Test valid Contact object values
    @Test
    void testContactClass() {
        Contact contact = new Contact("TestId123",
                "Cam",
                "Ward",
                "1234567890",
                "1900 Yellow Brick Rd");

        assertEquals("TestId123", contact.getContactId());
        assertEquals("Cam", contact.getFirstName());
        assertEquals("Ward", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("1900 Yellow Brick Rd", contact.getAddress());
    }

    // Test contactId is not null
    @Test
    void testContactIdIsNull() {
        assertThrows(IllegalArgumentException.class, () ->  {
            new Contact(null,
                    "Kirk",
                    "Cousins",
                    "1234567890",
                    "1900 Yellow Brick Rd");
        });
    }

    // Test contactId is not more than 10 characters long
    @Test
    void testContactIdLength() {
        assertThrows(IllegalArgumentException.class, () ->  {
            new Contact("TestId12345",
                    "Brock",
                    "Purdy",
                    "1234567890",
                    "1900 Yellow Brick Rd");
        });
    }

    // Test contact id with exactly 10 characters
    @Test
    void testContactIdExactLength() {
        Contact contact = new Contact(
                "TestId1234",
                "Tyler",
                "Huntley",
                "1234567890",
                "1900 Yellow Brick Rd");

        assertEquals("TestId1234", contact.getContactId());
    }

    // Test firstName is not null
    @Test
    void testFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class, () ->  {
            new Contact("TestId123",
                    null,
                    "Penix",
                    "1234567890",
                    "1900 Yellow Brick Rd");
        });
    }

    // Test firstName is not more than 10 characters long
    @Test
    void testFirstNameLength() {
        assertThrows(IllegalArgumentException.class, () ->  {
            new Contact("TestId123",
                    "PatrickMahomes",
                    "Mahomes",
                    "1234567890",
                    "1900 Yellow Brick Rd");
        });
    }

    // Test firstName with exactly 10 characters
    @Test
    void testFirstNameExactLength() {
        String firstName = "a".repeat(10);

        Contact contact = new Contact(
                "TestId123",
                firstName,
                "McNair",
                "1234567890",
                "1900 Yellow Brick Rd");

        assertEquals(firstName, contact.getFirstName());
    }


    // Test lastName is not null
    @Test
    void testLastNameIsNull() {
        assertThrows(IllegalArgumentException.class, () ->  {
            new Contact("TestId123",
                    "Malik",
                    null,
                    "1234567890",
                    "1900 Yellow Brick Rd");
        });
    }

    // Test lastName is not more than 10 characters long
    @Test
    void testLastNameLength() {
        assertThrows(IllegalArgumentException.class, () ->  {
            new Contact("TestId123",
                    "Aaron",
                    "AaronRodgers",
                    "1234567890",
                    "1900 Yellow Brick Rd");
        });
    }

    // Test lastName with exactly 10 characters
    @Test
    void testLastNameExactLength() {
        String lastName = "a".repeat(10);

        Contact contact = new Contact(
                "TestId123",
                "Troy",
                lastName,
                "1234567890",
                "1900 Yellow Brick Rd");

        assertEquals(lastName, contact.getLastName());
    }

    // Test phoneNumber is not null
    @Test
    void testPhoneNumberIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("TestId123",
                    "Matthew",
                    "Stafford",
                    null,
                    "1900 Yellow Brick Rd");
        });
    }

    // Test phoneNumber is 10 digits long
    @Test
    void testPhoneNumberLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("TestId123",
                    "Justin",
                    "Herbert",
                    "1",
                    "1900 Yellow Brick Rd");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("TestId123",
                    "Jacoby",
                    "Brissett",
                    "12345678901",
                    "1900 Yellow Brick Rd");
        });
    }

    // Test phoneNumber contains only digits
    @Test
    void testPhoneNumberOnlyDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("TestId123",
                    "Baker",
                    "Mayfield",
                    "ABCDEFGHIJ",
                    "1900 Yellow Brick Rd");
        });
    }

    // Test address is not null
    @Test
    void testAddressIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("TestId123",
                    "CJ",
                    "Stroud",
                    "1234567890",
                    null);
        });
    }

    // Test address is not more than 30 characters long
    @Test
    void testAddressLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            String longAddress = "a".repeat(31);
            new Contact("TestId123",
                    "Sam",
                    "Darnold",
                    "1234567890",
                    longAddress);
        });
    }

    // Test address with exactly 30 characters
    @Test
    void testAddressExactLength() {
        String address = "a".repeat(30);

        Contact contact = new Contact(
                "TestId123",
                "Doug",
                "Flutie",
                "1234567890",
                address);

        assertEquals(address, contact.getAddress());
    }
}
