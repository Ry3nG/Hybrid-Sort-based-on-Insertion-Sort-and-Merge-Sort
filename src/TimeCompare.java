import java.io.*;

// import org.apache.commons.lang3.time.StopWatch;
import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;

public class TimeCompare {

    static final int MAX = 100; // Max value of array elements
    static final int ITER = 1000; // Number of iterations for each test
    static final int MAX_SIZE = 200; // Max size of array
    static final int INCREMENT = 1; // Increment size for array
    static final int MODULO = 1; // Modulo for nanoTime

    public static long mergeInplace(int size){
        int[] testArrInplace;
        long total = 0;

        for(int i = 0; i < ITER; i++){
            testArrInplace = GenerateInput.generateRandom(size, MAX);
            long begin, end;
            begin = System.currentTimeMillis();
            MergeSortInPlace.sortIt(testArrInplace,0,testArrInplace.length-1);
            end = System.currentTimeMillis();

            total += (end - begin);
        }

        return total/ITER;
    }

    public static long mergeOriginal(int size){

        int[] testArrOriginal; 
        long total = 0;

        for(int i = 0; i < ITER; i++){
            testArrOriginal = GenerateInput.generateRandom(size, MAX);
            //long begin, end;

            Stopwatch stopWatch = Stopwatch.createStarted();
            // begin = System.nanoTime()/MODULO;
            // begin = System.currentTimeMillis();

            MergeSortOriginal.sortIt(testArrOriginal,0,testArrOriginal.length-1);

            stopWatch.stop();
            // end = System.nanoTime()/MODULO;
            // end = System.currentTimeMillis();

            total += stopWatch.elapsed(TimeUnit.NANOSECONDS);
            stopWatch.reset();
        }

        return total/ITER;
    }

    public static long insertion(int size){
        int[] testArrInsert;
        long total = 0;

        for(int i = 0; i < ITER; i++){
            testArrInsert = GenerateInput.generateRandom(size, MAX);
            //long begin, end;

            Stopwatch stopWatch = Stopwatch.createStarted();
            // begin = System.currentTimeMillis();
            // begin = System.nanoTime()/MODULO;

            InsertionSort.sortIt(testArrInsert,0,testArrInsert.length-1);

            stopWatch.stop();
            // end = System.currentTimeMillis();
            // end = System.nanoTime()/MODULO;

            total += stopWatch.elapsed(TimeUnit.NANOSECONDS);
            stopWatch.reset();
        }

        return total/ITER;
    }

    public static long hybrid(int size){
        int[] testArrHybrid = GenerateInput.generateRandom(size, MAX);
        long total = 0;
        
        for(int i = 0; i < ITER; i++){
            testArrHybrid = GenerateInput.generateRandom(size, MAX);
            long begin, end;
            begin = System.currentTimeMillis();
            HybridSort.sortIt(testArrHybrid,0,testArrHybrid.length-1);
            end = System.currentTimeMillis();

            total += (end - begin);
        }

        return total/ITER;
    }

    public static void main(String[] args) throws IOException {
        int count = 0;
        long mergeTime1,  insertTime;

        // mergeTime1 = mergeOriginal(1000);

        long[] mergeTimes = new long[MAX_SIZE/INCREMENT];

        for(int i = 2; i <= MAX_SIZE; i += INCREMENT){
            System.out.println("Iteration: " + count + ", Size: " + i);
            mergeTime1 = mergeOriginal(i);
            mergeTimes[count] = mergeTime1;
            count++;
        }

        makeCSV.CSVprinter(mergeTimes, "merge.csv");

        count = 0;
        long[] insertTimes = new long[MAX_SIZE/INCREMENT];

        for(int i = 2; i <= MAX_SIZE; i += INCREMENT){
            System.out.println("Iteration: " + count + ", Size: " + i);
            insertTime = insertion(i);
            insertTimes[count] = insertTime;
            count++;
        }
        
        makeCSV.CSVprinter(insertTimes, "insert.csv");

        // mergeTime1 = mergeInplace(size);
        // mergeTime2 = mergeOriginal(size);
        // insertTime = insertion(size);
        // hybridTime = hybrid(size);

        // System.out.println("Average Time for MergeSort(Inplace) over " + ITER + " runs : "+ mergeTime1 + " ms");
        // System.out.println("Average Time for MergeSort(Original) over " + ITER + " runs : "+ mergeTime2 + " ms");
        // System.out.println("Average Time for InsertionSort over " + ITER + " runs : "+ insertTime + " ms");
        // System.out.println("Average Time for HybridSort over " + ITER + " runs : "+ hybridTime + " ms");
        // System.out.println("\nHybridSort is "+ ((double)hybridTime/(double)mergeTime2)*100 + "% of the original MergeSort");
    }
}
