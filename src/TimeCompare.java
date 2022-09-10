

public class TimeCompare {
    static final int MAX = 100; // Max value of array elements
    static final int ITER = 50; // Number of iterations for each test

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
            long begin, end;
            begin = System.currentTimeMillis();
            MergeSortOriginal.sortIt(testArrOriginal,0,testArrOriginal.length-1);
            end = System.currentTimeMillis();

            total += (end - begin);
        }

        return total/ITER;
    }

    public static long insertion(int size){
        int[] testArrInsert;
        long total = 0;

        for(int i = 0; i < ITER; i++){
            testArrInsert = GenerateInput.generateRandom(size, MAX);
            long begin, end;
            begin = System.currentTimeMillis();
            InsertionSort.sortIt(testArrInsert,0,testArrInsert.length-1);
            end = System.currentTimeMillis();

            total += (end - begin);
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

    public static void main(String[] args) {
        int size = 80000;

        long mergeTime1, mergeTime2, insertTime, hybridTime;

        mergeTime1 = mergeInplace(size);
        mergeTime2 = mergeOriginal(size);
        insertTime = insertion(size);
        hybridTime = hybrid(size);

        System.out.println("Average Time for MergeSort(Inplace) over " + ITER + " runs : "+ mergeTime1 + " ms");
        System.out.println("Average Time for MergeSort(Original) over " + ITER + " runs : "+ mergeTime2 + " ms");
        System.out.println("Average Time for InsertionSort over " + ITER + " runs : "+ insertTime + " ms");
        System.out.println("Average Time for HybridSort over " + ITER + " runs : "+ hybridTime + " ms");
        System.out.println("\nHybridSort is "+ ((double)hybridTime/(double)mergeTime2)*100 + "% of the original MergeSort");
    }
}
