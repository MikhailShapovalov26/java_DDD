package ru.netology;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    static PhoneBook phoneBook;
    private String testName1 = "User";
    private String testNumber1 = "+79999999998";
    private String testName2 = "Test2";
    private String testNumber2 = "+79999999999";

    @Before
    public void setUp() {
        phoneBook = new PhoneBook();
        phoneBook.add(testName1, testNumber1);
        phoneBook.add(testName2, testNumber2);
    }


    @Test
    public void testAddPhoneBook() {
        PhoneBook tempPhoneBook = new PhoneBook();
        assertEquals(3, tempPhoneBook.add("Anton", "+79344444545"));
        assertEquals(0, tempPhoneBook.add("Anton", "+79344444545"));
    }


    @Test
    public void testFindByNumber() {
        assertEquals("Test2", phoneBook.findByNumber("+79999999999"));
    }

    @Test
    public void testFindByName() {
        assertEquals("+79999999999", phoneBook.findByName("Test2"));
    }

    @Test
    public void testPrintAllNames() {
        List<String> sortName = new ArrayList<>();
        sortName.add(testName1);
        sortName.add(testName2);
        Collections.sort(sortName);
        assertEquals(sortName, phoneBook.printAllNames());
    }

}