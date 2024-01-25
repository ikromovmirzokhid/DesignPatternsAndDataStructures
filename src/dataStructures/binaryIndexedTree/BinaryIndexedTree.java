package dataStructures.binaryIndexedTree;

public class BinaryIndexedTree {
    int[] indexArray;
    int[] arr;

    BinaryIndexedTree(int size) {
        if (size <= 0) throw new IllegalArgumentException("Size is less or equal to zero");
        indexArray = new int[size + 1];
        arr = new int[size];
        buildIndexedArray();
    }

    BinaryIndexedTree(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("Array is null");
        this.arr = arr;
        indexArray = new int[arr.length + 1];
        buildIndexedArray();
    }

    private void buildIndexedArray() {
        System.arraycopy(arr, 0, indexArray, 1, arr.length);
        for (int i = 1; i < indexArray.length; i++) {
            int lsb = i + lsb(i);
            if (lsb < indexArray.length)
                indexArray[lsb] = indexArray[lsb] + indexArray[i];
        }
    }
    private int lsb(int i) {
        return Integer.lowestOneBit(i);
    }

    public int sum(int i, int j) {
        if(i > j) throw new IllegalArgumentException(j + " is less than " + i);
        return sum(j) - sum(i - 1);
    }

    public int sum(int i) {
        if(i >= arr.length) throw new IllegalArgumentException(i + " equal or more than array length " + arr.length);
        i = i + 1;
        int sum = 0;
        while(i != 0) {
            sum += indexArray[i];
            i -= lsb(i);
        }
        return sum;
    }

    public void update(int i, int val) {
        if(i >= arr.length) throw new IllegalArgumentException(i + " is equal or more than array length " + arr.length);
        arr[i] = val;
        i++;
        while(i < indexArray.length) {
            indexArray[i] += val;
            i += lsb(i);
        }
    }
}
