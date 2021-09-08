package ru.bh.level2.les3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private HashMap<String, List<String>> hm;

    public PhoneBook() {
        hm = new HashMap<>();
    }

    public void add(String surname, String phone) {
        List<String> phoneList = hm.get(surname);
        if (hm.containsKey(surname)) {  //Проверяет наличие ключа в коллекции
            phoneList.add(phone);
            hm.put(surname, phoneList);
        } else {
            phoneList = new ArrayList<>();
            phoneList.add(phone);
            hm.put(surname, phoneList);
        }
    }

    public List<String> get(String surname) {
        System.out.println(surname + ": " + hm.get(surname));
        return hm.get(surname);
    }
}