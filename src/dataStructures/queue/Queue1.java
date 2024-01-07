package dataStructures.queue;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Queue1<T> implements Iterable<T> {
    private T[] array;
    private int size = 0;
    private int capacity = 0;

    public Queue1() {
        this(4);
    }

    public Queue1(int size) {
        array = (T[]) new Object[size];
        capacity = size;
    }

    public void enqueue(T obj) {
        if (obj == null) throw new RuntimeException("Element is null");
        if (size >= capacity) {
            capacity = 2 * capacity;
            T[] tempArr = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++)
                tempArr[i] = array[i];
            array = tempArr;
        }
        array[size++] = obj;
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T[] tempArr = (T[]) new Object[capacity];
        T data = array[0];
        for (int i = 1; i < size; i++)
            tempArr[i - 1] = array[i];
        array = tempArr;
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public T next() {
                return array[i++];
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size - 1; i++)
            builder.append(array[i]).append(", ");
        builder.append(array[size - 1]).append("]");
        return builder.toString();
    }
}
