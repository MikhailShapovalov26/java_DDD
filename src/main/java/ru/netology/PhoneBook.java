package ru.netology;

import java.util.*;

public class PhoneBook {
    private static Map<String,String> phoneBook = new HashMap<>();

    public int add(String name, String number){
        if(name ==null || number ==null){
            return 0;
        }
        if( !phoneBook.containsKey(name)){
            phoneBook.put(name, number);
            return phoneBook.size();
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
       return phoneBook.get(name);
    }

    public List<String> printAllNames(){
        List<String> l = new ArrayList<String>(phoneBook.keySet());
        Collections.sort(l);
        return l;
    }
}
