package dataStructures.HashTable.seprateChaining;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer, String> users = new HashTable<>();
        users.put(0, "Miz");
        users.put(1, "Fazik");
        users.put(2, "Jama");
        users.put(3, "A");
        users.put(4, "B");
        users.put(5, "C");
        users.put(6, "D");
        users.put(7, "E");
        users.remove(5);
        System.out.println(users);
        for (Integer user : users) {
            System.out.println(user);
        }
    }
}