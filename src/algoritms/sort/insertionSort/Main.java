package algoritms.sort.insertionSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 35, -15, 7, 55, 1, -22};
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int temp = arr[firstUnsortedIndex];
            int place = firstUnsortedIndex;
            for (int i = firstUnsortedIndex - 1; i >= 0 && arr[i] > temp; i--) {
                arr[place] = arr[i];
                place = i;
            }
            arr[place] = temp;
        }

        for (int elem : arr) {
            System.out.println(elem);
        }
    }
}