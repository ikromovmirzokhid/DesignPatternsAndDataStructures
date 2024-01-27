package algoritms.sort.quickSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, -1, 1, 0, -11, -5, 20, -15};
        quickSort(arr, 0, arr.length);
        for (int a : arr)
            System.out.println(a);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end - start < 2) return;
        int pivotIndex = pivotIndex(arr, start, end);
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex + 1, end);
    }

    public static int pivotIndex(int[] arr, int start, int end) {
        int pivot = arr[start];
        int l = start, r = end;
        while(l < r) {
            while(l < r && arr[--r] >= pivot);
            arr[l] = arr[r];
            while(l < r && arr[++l] <= pivot);
            if(l <= r)
                arr[r] = arr[l];
        }
        arr[r] = pivot;
        return r;
    }
}