package ru.netology;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();
    private final String testName1 = "User";
    private final String testNumber1 = "+79999999998";
    private final String testName2 = "Test2";
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
        assertEquals("Test2",phoneBook.findByNumber("+79999999999"));
    }

    @Test
    public void testFindByName(){
        phoneBook.add(testName1, testNumber1);
        phoneBook.add(testName2, testNumber2);
        assertEquals("+79999999999", phoneBook.findByName("Test2") );
    }

    @Test
    public void testPrintAllNames(){
        phoneBook.add(testName1, testNumber1);
        phoneBook.add(testName2, testNumber2);
        List<String> sortName = new ArrayList<>();
        sortName.add(testName1);
        sortName.add(testName2);
        Collections.sort(sortName);
        assertEquals(sortName, phoneBook.printAllNames());
    }

}