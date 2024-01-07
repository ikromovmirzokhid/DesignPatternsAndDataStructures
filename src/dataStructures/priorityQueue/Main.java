package dataStructures.priorityQueue;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] ints = new Integer[]{8, 9, 2, 5, 0, 1, 7, 2, 4, 0, 6};
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);
        list.add(2);
        list.add(5);
        list.add(0);
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(4);
        list.add(0);
        list.add(6);
        PQueue<Integer> integerPQueue = new PQueue<>(list);
        integerPQueue.poll();
        System.out.println(integerPQueue.isMinHeap(0));
    }
}