package ru.netology;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PhoneBookTest {

    @Test
    public void testAddPhoneBook(){
        String name = "test";
        String number = "+79999999999";
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1, phoneBook.add(name, number));
    }
@Test
    public void testAddPhoneBookRepetition(){
        String name = "test";
        String number = "+79999999999";
        String name2 = "test";
        String number2 = "+79999999999";
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1,phoneBook.add(name, number));
        assertEquals(0, phoneBook.add(name2, number2));
    }
}