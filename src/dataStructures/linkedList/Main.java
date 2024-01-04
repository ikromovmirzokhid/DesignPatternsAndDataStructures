package dataStructures.linkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        System.out.println(integers);
//        integers.removeFirst();
//        integers.removeLast();
        integers.removeAt(2);
        System.out.println(integers);
        integers.remove(1);
        System.out.println(integers);
        System.out.println(integers.contains(1));
    }
}