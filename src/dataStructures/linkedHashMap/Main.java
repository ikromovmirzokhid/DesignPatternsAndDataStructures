package dataStructures.linkedHashMap;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(2);
        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);
        System.out.println(linkedHashMap.get(1));
        linkedHashMap.put(3, 3);
        System.out.println(linkedHashMap.get(2));
        linkedHashMap.put(4, 4);
        System.out.println(linkedHashMap.get(1));
        System.out.println(linkedHashMap.get(3));
        System.out.println(linkedHashMap.get(4));
    }
}
