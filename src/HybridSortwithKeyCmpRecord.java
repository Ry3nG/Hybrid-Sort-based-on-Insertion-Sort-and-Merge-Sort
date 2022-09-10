import java.util.*;

public class HybridSortwithKeyCmpRecord {
    static int S = 30;
    static int keyCmp;

    public static void main(String[] args) {
        double[] test1Result = keyCmpwithInputTest();
        System.out.println("Test 1: " + Arrays.toString(test1Result));

        double[] test2Result = keyCmpwithSTest();
        System.out.println("Test 2: " + Arrays.toString(test2Result));
    }

    public static double[] keyCmpwithInputTest() {
        // S fixed, number of key comparisons over different sizes of input size:
        int count = 0;
        double[] keyCmpArr = new double[1000];
        for (int i = 1000; i < 10000000; i += 1000) {
            double average = 0;
            for (int j = 0; j < 5; j++) {
                keyCmp = 0;
                int[] testArr = GenerateInput.generateRandom(i, 1000);
                hybridSortIt(testArr, 0, testArr.length - 1);
                average += keyCmp;
            }
            keyCmpArr[count++] = average / 5;
            System.out.println("Generating keyCmp-input results... " + count);
        }
        return keyCmpArr;
    }

    public static double[] keyCmpwithSTest() {
        // input size fixed,test for different value of S
        int count = 0;
        double[] keyCmpArr = new double[100];
        for (int i = 0; i < 100; i += 1) {
            S = i;
            double average = 0;
            for (int j = 0; j < 5; j++) {
                keyCmp = 0;
                int[] testArr = GenerateInput.generateRandom(100000, 1000);
                hybridSortIt(testArr, 0, testArr.length - 1);
                average += keyCmp;
            }
            keyCmpArr[count++] = average / 5;
            System.out.println("Generating keyCmp-S results... " + count);
        }
        return keyCmpArr;
    }

    public static void hybridSortIt(int[] arr, int start, int end) {
        if (arr.length < S) {
            insertionSortIt(arr, start, end);
        } else {
            if (start < end) {
                keyCmp++;
                int mid = start + (end - start) / 2;

                hybridSortIt(arr, start, mid);
                hybridSortIt(arr, mid + 1, end);

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
                keyCmp++;
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

    public static void insertionSortIt(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            for (int j = i; j > 0; j--) {
                keyCmp++;
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
