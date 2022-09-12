import java.io.IOException;
import java.util.*;

public class HybridSortwithKeyCmp {
    static int S = 124;
    static int keyCmp;

    static final int TEST_SIZE = 10000000;
    static final int TEST_VALUE = 1000;
    static final int ITER = 10; // number of each test to be averaged

    public static void main(String[] args) throws IOException {
        generateTestResults();
        //getHybridSortKeyCmpandTime();

    }

    public static long[] getHybridSortKeyCmpandTime() {
        long[] result = new long[2]; // result[0] is keyCmp, result[1] is CPU time
        long averageKeyCmp = 0;
        long averageTime = 0;
        for (int i = 0; i < ITER; i++) {
            System.out.println("Testing trial (HybridSort) " + (i + 1) + " ... ");
            keyCmp = 0;
            int[] testArr = GenerateInput.generateRandom(TEST_SIZE, TEST_VALUE);
            long t0 = System.currentTimeMillis();
            hybridSortIt(testArr, 0, testArr.length - 1);
            averageTime += System.currentTimeMillis() - t0;
            averageKeyCmp += keyCmp;
        }
        averageKeyCmp /= ITER;
        averageTime /= ITER;
        result[0] = averageKeyCmp;
        result[1] = averageTime;
        // System.out.println("Average keyCmp for HybridSort: " + averageKeyCmp);
        // System.out.println("Average CPU Time for HybridSort: " + averageTime+"ms");
        return result;
    }

    public static void generateTestResults() throws IOException {
        long[] test2Result = keyCmpwithSTest();
        System.out.println("Test 2: " + Arrays.toString(test2Result));
        makeCSV.CSVprinter(test2Result, "test2.csv");

        //long[] test1Result = keyCmpwithInputTest();
        //System.out.println("Test 1: " + Arrays.toString(test1Result));
        //makeCSV.CSVprinter(test1Result, "test1.csv");
    }

    public static long[] keyCmpwithInputTest() {
        // S fixed, number of key comparisons over different sizes of input size:
        int count = 0;
        long[] keyCmpArr = new long[10000];
        for (int i = 10000; i <= 10000000; i += 10000) {
            long average = 0;
            for (int j = 0; j < 5; j++) {
                keyCmp = 0;
                int[] testArr = GenerateInput.generateRandom(i, TEST_VALUE);
                hybridSortIt(testArr, 0, testArr.length - 1);
                average += keyCmp;
            }
            keyCmpArr[count++] = average / 5;
            System.out.println("Generating keyCmp-input results... " + count+ " Current value is "+keyCmpArr[count-1]);
        }
        return keyCmpArr;
    }

    public static long[] keyCmpwithSTest() {
        // input size fixed,test for different value of S
        int count = 0;
        long[] keyCmpArr = new long[1000];
        for (int i = 0; i < 1000; i += 1) {
            S = i;
            long average = 0;
            for (int j = 0; j < 100; j++) {
                keyCmp = 0;
                int[] testArr = GenerateInput.generateRandom(1000, 1000);
                hybridSortIt(testArr, 0, testArr.length - 1);
                average += keyCmp;
            }
            keyCmpArr[count++] = average / 100;
            System.out.println("Generating keyCmp-S results... " + count);
        }
        return keyCmpArr;
    }

    public static void hybridSortIt(int[] arr, int start, int end) {
        if (start < end) {
            //keyCmp++;
            int mid = start + (end - start) / 2;

            hybridSortIt(arr, start, mid);
            hybridSortIt(arr, mid + 1, end);

            merge(arr, start, mid, end);
        }

    }

    public static void merge(int[] arr, int start, int mid, int end) {
        if (arr.length <= S) {
            insertionSortIt(arr, start, end);
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
