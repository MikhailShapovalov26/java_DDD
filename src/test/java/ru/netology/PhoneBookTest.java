package ru.netology;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();

    @Test
    public void testAddPhoneBook() {
        String name = "test";
        String number = "+79999999999";
        assertEquals(1, phoneBook.add(name, number));
    }

    @Test
    public void testAddPhoneBookRepetition() {
        String name = "test";
        String number = "+79999999999";
        String name2 = "test";
        String number2 = "+79999999998";
        assertEquals(1, phoneBook.add(name, number));
        assertNotEquals(1, phoneBook.add(name2, number2));
    }

    @BeforeEach
    void setUp() {
        String name = "test";
        String number = "+79999999998";
        String name2 = "test2";
        String number2 = "+79999999999";

        phoneBook.add(name, number);
        phoneBook.add(name2, number2);
    }

    @Test
    public void findByNumber() {
        String name = "test";
        String number = "+79999999998";
        String name2 = "test2";
        String number2 = "+79999999999";

        phoneBook.add(name, number);
        phoneBook.add(name2, number2);
        String numberTest = "+7999999999";
        System.out.println(phoneBook.toString());
        assertEquals("test2",phoneBook.findByNumber(numberTest));
    }

}