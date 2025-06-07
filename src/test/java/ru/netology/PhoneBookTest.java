package ru.netology;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();
    private final String testName1 = "test1";
    private final String testNumber1 = "+79999999998";
    private final String testName2 = "test2";
    private final String testNumber2 = "+79999999999";

    @Test
    public void testAddPhoneBook() {
        assertEquals(1, phoneBook.add(testName1, testNumber1));
    }

    @Test
    public void testAddPhoneBookRepetition() {
        assertEquals(1, phoneBook.add(testName1, testNumber1));
        assertNotEquals(1, phoneBook.add(testName1, testNumber1));
    }

    @Test
    public void testFindByNumber() {
        phoneBook.add(testName1, testNumber1);
        phoneBook.add(testName2, testNumber2);
        assertEquals("test2",phoneBook.findByNumber("+79999999999"));
    }

    @Test
    public void testFindByName(){
        phoneBook.add(testName1, testNumber1);
        phoneBook.add(testName2, testNumber2);
        assertEquals("+79999999999", phoneBook.findByName("test2") );
    }

}