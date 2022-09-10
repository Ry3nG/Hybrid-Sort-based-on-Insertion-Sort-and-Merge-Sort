import java.util.*;

public class HybridSort {
    static final int S = 40; // switch to insertion sort if array size smaller than S

    public static void main(String[] args) throws Exception {
        int[] testArr = GenerateInput.generateRandom(10, 1000);
        sortIt(testArr, 0, testArr.length - 1);
        System.out.println(Arrays.toString(testArr));
    }

    public static void sortIt(int[] arr, int start, int end) {
        if (arr.length <= S) {
            InsertionSort.sortIt(arr, start, end);
        } else {
            if (start < end) {
                int mid = start + (end - start) / 2;

                sortIt(arr, start, mid);
                sortIt(arr, mid + 1, end);

                merge(arr, start, mid, end);
            }
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        if (arr.length <= S) {
            InsertionSort.sortIt(arr, start, end);
        } else {
            int n1 = mid - start + 1;
            int n2 = end - mid;
            int[] L = new int[n1];
            int[] R = new int[n2];

            for (int i = 0; i < n1; ++i)
                L[i] = arr[start + i];
            for (int j = 0; j < n2; ++j)
                R[j] = arr[mid + 1 + j];

            int i = 0, j = 0;
            int k = start;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

    }
}
