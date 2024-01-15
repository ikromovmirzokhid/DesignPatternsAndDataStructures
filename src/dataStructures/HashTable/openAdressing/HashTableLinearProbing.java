package dataStructures.HashTable.openAdressing;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class HashTableLinearProbing<K, V> implements Iterable<K> {

    private static final int DEFAULT_CAPACITY = 8;
    private static final double DEFAULT_LOAD_FACTOR = 0.5;

    private int capacity, modificationCount, threshold;
    private int usedBucketCount, keysCount;
    private double loadFactor;

    private K[] keysTable;
    private V[] valuesTable;
    private K tombStone = (K) new Object();

    public HashTableLinearProbing(int capacity) {
        if (capacity < 0) throw new RuntimeException("Illegal capacity " + capacity);
        this.capacity = Math.max(DEFAULT_CAPACITY, next2Power(capacity));
        loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int) (capacity * loadFactor);
        keysTable = (K[]) new Object[this.capacity];
        valuesTable = (V[]) new Object[this.capacity];
    }

    public HashTableLinearProbing() {
        this(DEFAULT_CAPACITY);
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            keysTable[i] = null;
            valuesTable[i] = null;
        }
        keysCount = usedBucketCount = modificationCount = 0;
    }

    public int size() {
        return keysCount;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean hasKey(K key) {
        return containsKey(key);
    }

    public boolean containsKey(K key) {
        if (key == null) throw new RuntimeException("Illegal key null");
        return get(key) != null;
    }

    public V put(K key, V value) {
        return insert(key, value);
    }

    public V add(K key, V value) {
        return insert(key, value);
    }

    public V insert(K key, V value) {
        if (key == null) throw new RuntimeException("Illegal key null");
        int index = normalizeIndex(key.hashCode());
        int j = -1;
        int x = 1;
        while (keysTable[index] != null) {
            if (keysTable[index].equals(key)) {
                V oldVal = valuesTable[index];
                valuesTable[index] = value;
                modificationCount++;
                return oldVal;
            }
            if (keysTable[index] == tombStone)
                j = index;
            index = ((key.hashCode() + P(x)) / capacity);
            x++;
        }
        modificationCount++;
        usedBucketCount++;
        keysCount++;
        if (j != -1) {
            keysTable[index] = tombStone;
            valuesTable[index] = null;
            index = j;
        }
        keysTable[index] = key;
        valuesTable[index] = value;
        if (usedBucketCount >= threshold)
            resize();
        return null;
    }

    public V remove(K key) {
        if (key == null) throw new RuntimeException("Illegal key null");
        int index = normalizeIndex(key.hashCode());
        int x = 0;
        while (keysTable[index] != null) {
            if (keysTable[index] == key) {
                modificationCount++;
                keysCount--;
                V oldVal = valuesTable[index];
                keysTable[index] = tombStone;
                valuesTable[index] = null;
                return oldVal;
            }
            index = (key.hashCode() + P(x)) / capacity;
            x++;
        }
        return null;
    }

    private void resize() {
        int oldCapacity = capacity;
        usedBucketCount = keysCount = 0;
        capacity = 2 * capacity;
        threshold = (int) (capacity * loadFactor);
        K[] oldKeyTable = (K[]) new Object[capacity];
        V[] oldValueTable = (V[]) new Object[capacity];

        K[] keyTemp = keysTable;
        keysTable = oldKeyTable;
        oldKeyTable = keyTemp;

        V[] valueTemp = valuesTable;
        valuesTable = oldValueTable;
        oldValueTable = valueTemp;

        for (int i = 0; i < oldCapacity; i++) {
            if (oldKeyTable[i] != null && oldKeyTable[i] != tombStone) {
                insert(oldKeyTable[i], oldValueTable[i]);
            }
        }
    }

    public V get(K key) {
        if (key == null) throw new RuntimeException("Illegal key null");
        int x = 1;
        int j = -1;
        int index = normalizeIndex(key.hashCode());
        while (true) {
            if (keysTable[index] == null)
                return null;
            else {
                if (keysTable[index].equals(key)) {
                    if (j != -1) {
                        keysTable[j] = keysTable[index];
                        valuesTable[j] = valuesTable[index];
                        valuesTable[index] = null;
                        keysTable[index] = tombStone;
                        index = j;
                    }
                    return valuesTable[index];
                } else if (keysTable[index] == tombStone) {
                    j = index;
                }
                index = ((key.hashCode() + P(x)) / capacity);
                x++;
            }
        }
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (keysTable[i] != null && keysTable[i] != tombStone)
                keys.add(keysTable[i]);
        }
        return keys;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (keysTable[i] != null && keysTable[i] != tombStone)
                values.add(valuesTable[i]);
        }
        return values;
    }

    private int P(int x) {
        return x;
    }

    private int normalizeIndex(int keyHash) {
        return (keyHash & 0x7FFFFFFF) / capacity;
    }

    private int next2Power(int c) {
        return Integer.highestOneBit(c) << 1;
    }

    @Override
    public Iterator<K> iterator() {
        int MODIFICATION_COUNT = modificationCount;
        return new Iterator<K>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (MODIFICATION_COUNT != modificationCount) throw new ConcurrentModificationException();
                for (int i = index; i < capacity; i++) {
                    if (keysTable[i] != null && keysTable[i] != tombStone) {
                        index = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if (MODIFICATION_COUNT != modificationCount) throw new ConcurrentModificationException();
                return keysTable[index++];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < capacity; i++) {
            if (keysTable[i] != null && keysTable[i] != tombStone)
                builder.append(valuesTable[i]).append(", ");
        }
        String data = builder.toString();
        if (keysCount > 1) data = data.substring(0, data.length() - 2);
        data += "}";
        return data;
    }
}
