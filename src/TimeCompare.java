import java.util.Arrays;

public class TimeCompare {

    public static long mergeInplace(int[] testArrInplace){
        long begin, end;
        begin = System.nanoTime();
        MergeSortInPlace.sortIt(testArrInplace,0,testArrInplace.length-1);
        //end = System.currentTimeMillis();
        end = System.nanoTime();
        return end-begin;
    }

    public static long mergeOriginal(int[] testArrOriginal){
        long begin, end;
        begin = System.nanoTime();
        MergeSortOriginal.sortIt(testArrOriginal,0,testArrOriginal.length-1);
        //end = System.currentTimeMillis();
        end = System.nanoTime();
        return end-begin;
    }

    public static long insertion(int[] testArrInsert){
        long begin, end;
        begin = System.nanoTime();
        InsertionSort.sortIt(testArrInsert,0,testArrInsert.length-1);
        //end = System.currentTimeMillis();
        end = System.nanoTime();
        return end-begin;
    }

    public static long hybrid(int[] testArrHybrid){
        long begin, end;
        begin = System.nanoTime();
        HybridSort.sortIt(testArrHybrid,0,testArrHybrid.length-1);
        //end = System.currentTimeMillis();
        end = System.nanoTime();
        return end-begin;
    }

    public static void main(String[] args) {
        // 3 copies of the same array
        int[] testArr1 = GenerateInput.generateRandom(100000, 100);
        
        int[] testArr2 = Arrays.copyOf(testArr1, testArr1.length);
        int[] testArr3 = Arrays.copyOf(testArr1, testArr1.length);
        int[] testArr4 = Arrays.copyOf(testArr1, testArr1.length);

        System.arraycopy(testArr1, 0, testArr2,0, testArr1.length);
        long mergeTime1, mergeTime2, insertTime, hybridTime;

        mergeTime1 = mergeInplace(testArr1);
        mergeTime2 = mergeOriginal(testArr2);
        insertTime = insertion(testArr3);
        hybridTime = hybrid(testArr4);

        System.out.println("Time for MergeSort(Inplace) : "+ mergeTime1 + " ms");
        System.out.println("Time for MergeSort(Orignal) : "+ mergeTime2 + " ms");
        System.out.println("Time for InsertionSort: "+ insertTime + " ms");
        System.out.println("Time for HybridSort: "+ hybridTime + " ms");
        System.out.println("\nHybridSort is "+ ((double)hybridTime/(double)mergeTime2) *100+ "% of the original MergeSort");
        
    }
    
}
