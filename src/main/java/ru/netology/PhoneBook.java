package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static Map<String,String> phoneBook = new HashMap<>();

    public int add(String name, String number){
        if(name ==null || number ==null){
            return 0;
        }
        if( !phoneBook.containsKey(name)){
            phoneBook.put(name, number);
            return 1;
        }
        return 0;
    }

    public String findByNumber(String number){
        if(!phoneBook.isEmpty()) {
            return phoneBook.
                    entrySet().
                    stream().
                    filter(entry -> number.equals(entry.getValue())).
                    map(Map.Entry::getKey).
                    findFirst().
                    get();
        }
        return null;

    }

    public String findByName(String name){
        return null;
    }
}
