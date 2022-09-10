import java.util.*;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] testArr = { 3, 5, 7, 8, 4, 6, 7, 9 };
        sortIt(testArr, 0, testArr.length - 1);
        System.out.println(Arrays.toString(testArr));
    }

    public static void sortIt(int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        if ((mid - start) <= 0)
            return;
        else if ((mid - start) > 1) {
            sortIt(arr, start, mid);
            sortIt(arr, mid + 1, end);
        }
        merge(arr, start, end);

    }

    public static void merge(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        int a = start, b = mid + 1;
        int temp;

        if ((end - start) <= 0)
            return;
        while (a <= mid && b <= end) {
            if (arr[a] < arr[b]) {
                a++;
            } else if (arr[a] > arr[b]) {
                temp = arr[b++];
                for (int i = ++mid; i > a; i--) {
                    arr[i] = arr[i - 1];
                    arr[a++] = temp;
                }
            } else {
                if (a == mid && b == end) {
                    break;
                }
                temp = arr[b++];
                a++;
                for (int i = ++mid; i > a; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[a++] = temp;
            }
        }

    }
}
