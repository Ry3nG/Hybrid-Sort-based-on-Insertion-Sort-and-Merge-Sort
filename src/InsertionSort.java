import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 2, 4, 6, 11, 8, 9 };
        sortIt(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void sortIt(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
