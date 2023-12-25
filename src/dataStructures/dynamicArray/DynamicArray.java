package dataStructures.dynamicArray;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {
    private T[] arr;
    private int size = 0;
    private int capacity = 0;

    public DynamicArray() {
        this(4);
    }

    public DynamicArray(int capacity) {
        arr = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index < 0) throw new IllegalArgumentException("no such index " + index);
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        return arr[index];
    }

    public void set(int index, T obj) {
        if (index < 0) throw new IllegalArgumentException("no such index " + index);
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        arr[index] = obj;
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            arr[i] = null;
        size = 0;
    }

    public void add(T obj) {
        if (size + 1 > capacity) {
            capacity *= 2;
            T[] temp = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++)
                temp[i] = arr[i];
            temp[size++] = obj;
            this.arr = temp;
        } else {
            arr[size++] = obj;
        }
    }

    public void removeAt(int index) {
        if (index < 0) throw new IllegalArgumentException("no such index " + index);
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i != index) {
                temp[j] = arr[i];
            } else
                j--;
        }
        this.arr = temp;
        size--;
    }

    public boolean remove(T obj) {
        int index = indexOf(obj);
        if (index == -1)
            return false;
        removeAt(index);
        return true;
    }

    public int indexOf(T obj) {
        for (int i = 0; i < size; i++)
            if (arr[i] == obj)
                return i;
        return -1;
    }

    public boolean contains(T obj) {
        return indexOf(obj) != -1;
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
                return arr[i++];
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
            builder.append(arr[i]).append(", ");
        builder.append(arr[size - 1]).append("]");
        return builder.toString();
    }
}
