package dataStructures.linkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void clear() {
        Node<T> temp = head;
        while (temp != null) {
            temp.data = null;
            temp.prev = null;
            temp = temp.next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T obj) {
        addLast(obj);
    }

    public void addFirst(T obj) {
        if (isEmpty()) head = tail = new Node<>(obj, null, null);
        else {
            Node<T> node = new Node<>(obj, null, head);
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(T obj) {
        if (isEmpty()) head = tail = new Node<>(obj, null, null);
        else {
            Node<T> node = new Node<>(obj, tail, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("LinkedList is empty");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("LinkedList is empty");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("LinkedList is empty");
        T data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) tail = null;
        else head.prev = null;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("LinkedList is empty");
        T data = tail.data;
        tail = tail.prev;
        size--;
        if (isEmpty()) head = null;
        else tail.next = null;
        return data;
    }

    private T remove(Node<T> node) {
        T data = node.data;
        if (head == node) return removeFirst();
        if (tail == node) return removeLast();
        else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.data = null;
            node = node.prev = node.next = null;
            size--;
        }
        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("no such index " + index);
        Node<T> temp = head;
        for (int i = 0; i < size; i++, temp = temp.next) {
            if (i == index)
                return remove(temp);
        }
        return null;
    }

    public T remove(T obj) {
        int i = indexOf(obj);
        if (i == -1) throw new IllegalArgumentException("no such element");
        return removeAt(i);
    }

    public int indexOf(T obj) {
        Node<T> temp = head;
        for (int i = 0; i < size; i++, temp = temp.next) {
            if (temp.data.equals(obj))
                return i;
        }
        return -1;
    }

    public boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder builder = new StringBuilder("[");
        Node<T> temp = head;
        for (int i = 0; i < size - 1; i++) {
            builder.append(temp.data).append(", ");
            temp = temp.next;
        }
        builder.append(temp.data).append("]");
        return builder.toString();
    }
}
