package dataStructures.stack;

import dataStructures.linkedList.DoublyLinkedList;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private DoublyLinkedList<T> list = new DoublyLinkedList<>();

    public Stack() {
    }

    public Stack(T obj) {
        push(obj);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T obj) {
        list.addLast(obj);
    }

    public T pop() {
        if (isEmpty()) throw new IllegalArgumentException("Stack is empty");
        return list.removeLast();
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
