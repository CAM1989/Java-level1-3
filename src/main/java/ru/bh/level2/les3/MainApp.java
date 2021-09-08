package ru.bh.level2.les3;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<String> al1 = new ArrayList<>();
        al1.add("A");
        al1.add("B");
        al1.add("C");
        al1.add("D");
        al1.add("A");
        al1.add("F");

        ArrayList<String> bl1 = new ArrayList<>();

        bl1.add("A");
        bl1.add("F");

        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        set.add("A");
        set.add("B");
        set.add("CCC");
        set.add("DDDD");

        System.out.println(set);

        bl1.addAll(al1);

        System.out.println(bl1);


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Petrov","8-999-123-32-33");
        phoneBook.add("Ivanov","8-911-234-32-11");
        phoneBook.add("Antonov","8-988-345-32-22");
        phoneBook.add("Petrov","8-966-456-32-33");
        phoneBook.add("Mikhailov","8-678-654-32-44");
        phoneBook.add("Ivanov","8-944-890-32-55");
        phoneBook.add("Sidorov","8-933-012-32-66");
        phoneBook.add("Petrov","8-922-321-32-77");

        phoneBook.get("Petrov");
        phoneBook.get("Ivanov");
        phoneBook.get("Antonov");
        phoneBook.get("Sidorov");

        String[] city = {"Moscow","Saint-Petersburg","Barnaul","Saransk","Samara","Barnaul","Moscow","Novosibirsk","Saratov","Tomsk","Omsk","Barnaul"};
        HashSet unique = new HashSet(Arrays.asList(city));
        System.out.println(unique);

        HashMap<String, Integer> countCity = new HashMap<>();
        for (String c : city) {
            if (!countCity.containsKey(c)) {
                countCity.put(c, 0);
            }
            countCity.put(c, countCity.get(c) + 1);
        }
        for (String c : countCity.keySet()) {
            System.out.println(c + ": " + countCity.get(c));
        }

    }
}
