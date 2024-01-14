package dataStructures.HashTable.seprateChaining;

import dataStructures.dynamicArray.DynamicArray;
import dataStructures.linkedList.DoublyLinkedList;

import java.util.Arrays;
import java.util.Iterator;

class Entry<K, V> {
    int hash;
    K key;
    V val;

    public Entry(K key, V val) {
        this.key = key;
        this.val = val;
        hash = key.hashCode();
    }

    public boolean equals(Entry<K, V> other) {
        if (hashCode() != other.hash) return false;
        return key.equals(other.key);
    }

    @Override
    public String toString() {
        return key + " => " + val;
    }
}

@SuppressWarnings("unchecked")
public class HashTable<K, V> implements Iterable<K> {
    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    private int capacity, size, threshold;
    private double maxLoadFactor;

    private DoublyLinkedList<Entry<K, V>>[] table;

    public HashTable() {
        this(DEFAULT_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    public HashTable(int capacity, double maxLoadFactor) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity");
        if (maxLoadFactor < 0) throw new IllegalArgumentException("Illegal maxLoadFactor");
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.maxLoadFactor = maxLoadFactor;
        threshold = (int) (capacity * maxLoadFactor);
        table = new DoublyLinkedList[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int normalizeIndex(int keyHash) {
        return (keyHash & 0x7FFFFFFF) % capacity;
    }

    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public boolean containsKey(K key) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        return hasKey(key);
    }

    public boolean hasKey(K key) {
        return bucketGetEntry(key) != null;
    }

    public V add(K key, V val) {
        return insert(key, val);
    }

    public V put(K key, V val) {
        return insert(key, val);
    }

    public V insert(K key, V val) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        Entry<K, V> entry = new Entry<>(key, val);
        return bucketInsertEntry(entry);
    }

    public V remove(K key) {
        return bucketRemoveEntry(key);
    }

    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        Entry<K, V> entry = bucketGetEntry(key);
        if (entry != null)
            return entry.val;

        return null;
    }

    public DynamicArray<K> keys() {
        DynamicArray<K> keys = new DynamicArray<>(size);
        for (DoublyLinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null)
                for (Entry<K, V> entry : bucket)
                    keys.add(entry.key);
        }
        return keys;
    }

    public DynamicArray<V> values() {
        DynamicArray<V> values = new DynamicArray<>(size);
        for (DoublyLinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null)
                for (Entry<K, V> entry : bucket)
                    values.add(entry.val);
        }
        return values;
    }

    private V bucketInsertEntry(Entry<K, V> entry) {
        int index = normalizeIndex(entry.hash);
        DoublyLinkedList<Entry<K, V>> bucket = table[index];
        if (bucket == null) table[index] = bucket = new DoublyLinkedList<>();
        Entry<K, V> existentEntry = bucketGetEntry(entry.key);
        if (existentEntry != null) {
            V oldVal = existentEntry.val;
            existentEntry.val = entry.val;
            return oldVal;
        } else {
            bucket.add(entry);
            if (++size > threshold) {
                resizeTable();
            }
            return null;
        }
    }

    private V bucketRemoveEntry(K key) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        int index = normalizeIndex(key.hashCode());
        Entry<K, V> entry = bucketGetEntry(key);
        if (entry != null) {
            DoublyLinkedList<Entry<K, V>> bucket = table[index];
            bucket.remove(entry);
            if(bucket.isEmpty())
                table[index] = null;
            size--;
            return entry.val;
        }
        return null;
    }

    private void resizeTable() {
        capacity = capacity * 2;
        threshold = (int) (capacity * maxLoadFactor);
        DoublyLinkedList<Entry<K, V>>[] newTable = new DoublyLinkedList[capacity];
        for (DoublyLinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int index = normalizeIndex(entry.hash);
                    DoublyLinkedList<Entry<K, V>> newBucket = newTable[index];
                    if (newBucket == null) newTable[index] = newBucket = new DoublyLinkedList<>();
                    newBucket.add(entry);
                }
            }
        }
        Arrays.fill(table, null);
        table = newTable;
    }

    private Entry<K, V> bucketGetEntry(K key) {
        int index = normalizeIndex(key.hashCode());
        DoublyLinkedList<Entry<K, V>> bucket = table[index];
        if (bucket == null) {
            return null;
        }
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key))
                return entry;
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int tableIndex = -1;
            private Iterator<Entry<K, V>> currentBucketIterator;
            private DoublyLinkedList<Entry<K, V>> currentBucket;
            private int currentBucketIndex = 0;

            @Override
            public boolean hasNext() {
                if (currentBucket != null && currentBucketIndex < currentBucket.size()) {
                    return true;
                } else {
                    currentBucket = null;
                    currentBucketIndex = 0;
                    while (currentBucket == null) {
                        tableIndex++;
                        if (tableIndex >= capacity)
                            return false;
                        currentBucket = table[tableIndex];
                    }
                    currentBucketIterator = currentBucket.iterator();
                }

                return true;
            }

            @Override
            public K next() {
                currentBucketIndex++;
                return currentBucketIterator.next().key;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < capacity; i++) {
            DoublyLinkedList<Entry<K, V>> bucket = table[i];
            if (bucket != null)
                for (Entry<K, V> entry : bucket)
                    builder.append(entry).append(", ");
        }
        String res = builder.toString();
        if (builder.length() > 1) res = builder.substring(0, builder.length() - 2);
        res += "}";
        return res;
    }
}
