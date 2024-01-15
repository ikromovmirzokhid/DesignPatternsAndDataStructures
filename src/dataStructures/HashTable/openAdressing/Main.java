package dataStructures.HashTable.openAdressing;

public class Main {
    public static void main(String[] args) {
        HashTableLinearProbing<Integer, String> users = new HashTableLinearProbing<>();
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
        users.put(3, "Q");
        users.put(5, "123");
        System.out.println(users);
        System.out.println(users.size());
        for (Integer i : users) {
            System.out.println(users.get(i));
        }
    }
}