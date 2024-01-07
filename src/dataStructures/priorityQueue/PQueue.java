package dataStructures.priorityQueue;

import dataStructures.dynamicArray.DynamicArray;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class PQueue<T extends Comparable<T>> {
    private DynamicArray<T> list;
    private int heapSize = 0;
    private int heapCapacity = 0;

    private HashMap<T, TreeSet<Integer>> map = new HashMap<>();

    public PQueue() {
        this(1);
    }

    public PQueue(int size) {
        list = new DynamicArray<>(size);
    }

    public PQueue(T[] objs) {
        heapCapacity = heapSize = objs.length;
        list = new DynamicArray<>(heapCapacity);
        for (int i = 0; i < heapSize; i++) {
            list.add(objs[i]);
            mapSet(objs[i], i);
        }

        for (int i = Math.max(0, heapSize / 2 - 1); i >= 0; i--)
            sink(i);
    }

    public PQueue(Collection<T> elms) {
        this(elms.size());
        for (T element : elms)
            add(element);
    }

    public void clear() {
        list.clear();
        map.clear();
        heapSize = 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(T obj) {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        return map.containsKey(obj);
    }

    public void add(T obj) {
        if (heapSize < heapCapacity) {
            list.set(heapSize, obj);
        } else {
            list.add(obj);
            heapCapacity++;
        }
        mapSet(obj, heapSize);
        swim(heapSize);
        heapSize++;
    }

    public T poll() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        return removeAt(0);
    }

    public T remove(T obj) {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        if (obj == null) throw new RuntimeException("Object is null");
        Integer i = mapGet(obj);
        if (i == null) return null;
        return removeAt(i);
    }

    public T removeAt(int k) {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        if (k >= heapSize || k < 0) throw new RuntimeException("Out of index");
        T removedElement = list.get(k);
        heapSize--;
        if (heapSize == 0) {
            clear();
            return removedElement;
        }
        swap(k, heapSize);
        list.set(heapSize, null);
        mapRemove(removedElement, heapSize);
        T element = list.get(k);
        sink(k);
        if (list.get(k).equals(element))
            swim(k);
        return removedElement;
    }

    public boolean isMinHeap(int k) {
        if (k >= heapSize) return true;
        int left = 2 * k + 1;
        int right = 2 * k + 2;
        if (left < heapSize && !less(k, left)) return false;
        if (right < heapSize && !less(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    private void sink(int k) {
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;
            if (right < heapSize && less(right, left)) smallest = right;
            if (left >= heapSize || less(k, smallest)) break;
            swap(k, smallest);
            k = smallest;
        }
    }

    private void swim(int k) {
        if (k > 0) {
            int parent = (k - 1) / 2;
            while (k > 0 && parent >= 0 && less(k, parent)) {
                swap(k, parent);
                k = parent;
                parent = (k - 1) / 2;
            }
        }
    }

    private boolean less(int i, int j) {
        T elem1 = list.get(i);
        T elem2 = list.get(j);
        return elem1.compareTo(elem2) <= 0;
    }

    private Integer mapGet(T value) {
        TreeSet<Integer> positions = map.get(value);
        if (positions == null) return null;
        return positions.last();
    }

    private void mapSet(T value, int i) {
        TreeSet<Integer> positions = map.get(value);
        if (positions == null) {
            positions = new TreeSet<>();
        }
        positions.add(i);
        map.put(value, positions);
    }

    private void mapRemove(T value, int i) {
        TreeSet<Integer> positions = map.get(value);
        positions.remove(i);
        if (positions.isEmpty())
            map.remove(value);
        else
            map.put(value, positions);
    }

    private void swap(int i, int j) {
        T value1 = list.get(i);
        T value2 = list.get(j);
        list.set(i, value2);
        list.set(j, value1);
        mapSwap(value1, i, value2, j);
    }

    private void mapSwap(T value1, int i, T value2, int j) {
        TreeSet<Integer> positions1 = map.get(value1);
        TreeSet<Integer> positions2 = map.get(value2);

        positions1.remove(i);
        positions2.remove(j);

        positions1.add(j);
        positions2.add(i);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
