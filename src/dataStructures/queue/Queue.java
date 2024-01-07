package dataStructures.queue;

import dataStructures.linkedList.DoublyLinkedList;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private DoublyLinkedList<T> list = new DoublyLinkedList<>();

    public Queue() {
    }

    public Queue(T obj) {
        enqueue(obj);
    }

    public void enqueue(T obj) {
        if (obj == null) throw new RuntimeException("Element is null");
        list.addLast(obj);
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.removeFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder builder = new StringBuilder("[");
        Iterator<T> iterator = iterator();
        for (int i = 0; i < size() - 1; i++) {
            T element = iterator.next();
            builder.append(element).append(", ");
        }
        T element = iterator.next();
        builder.append(element).append("]");
        return builder.toString();
    }
}
