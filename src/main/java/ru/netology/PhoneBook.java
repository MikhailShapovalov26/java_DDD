package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static Map<String,String> phoneBook = new HashMap<>();

    public int add(String name, String number){
        if(name ==null || number ==null){
            return 0;
        }
        if( !phoneBook.containsValue(number)){
            phoneBook.put(name, number);
            return 1;
        }
        return 0;
    }
}
