import java.io.IOException;
import java.util.Arrays;

public class DeterminingS {
    static final int MAX_SIZE = 300;
    static final int MAX_VALUE = 1000;
    static final int ITER = 10000; // number of each test to be averaged

    public static void main(String[] args) throws IOException {
        long[] insertTimeSeries = timeInsertionSort();
        long[] mergeTimeSeries = timeMergeSort();
        System.out.println("Insertion sort: " + Arrays.toString(insertTimeSeries));
        System.out.println("Merge Sort: " + Arrays.toString(mergeTimeSeries));

        makeCSV.CSVprinter(insertTimeSeries, "insertTimeSeries.csv");
        makeCSV.CSVprinter(mergeTimeSeries, "mergeTimeSeries.csv");
    }

    // long t0 = System.currentTimeMillis();
    // long t1 = System.currentTimeMillis();

    public static long[] timeInsertionSort() {
        long[] insertTimeSeries = new long[MAX_SIZE];
        for (int size = 1; size <= MAX_SIZE; size++) {
            System.out.println("Generating time series..." + " insert" + " array size = " + size);
            long totalTime = 0;
            for (int i = 0; i < ITER; i++) {
                int[] testArr = GenerateInput.generateRandom(size, MAX_VALUE);
                long t0 = System.nanoTime();
                InsertionSort.sortIt(testArr, 0, testArr.length - 1);
                totalTime += System.nanoTime() - t0;
            }
            insertTimeSeries[size - 1] = totalTime / ITER;

        }
        return insertTimeSeries;
    }

    public static long[] timeMergeSort() {
        long[] mergeTimeSeries = new long[MAX_SIZE];
        for (int size = 1; size <= MAX_SIZE; size++) {
            System.out.println("Generating time series..." + " merge" + " array size " + size);
            long totalTime = 0;
            for (int i = 0; i < ITER; i++) {
                int[] testArr = GenerateInput.generateRandom(size, MAX_VALUE);
                long t0 = System.nanoTime();
                MergeSortOriginal.sortIt(testArr, 0, testArr.length - 1);
                totalTime += System.nanoTime() - t0;
            }
            mergeTimeSeries[size - 1] = totalTime / ITER;

        }
        return mergeTimeSeries;
    }
}