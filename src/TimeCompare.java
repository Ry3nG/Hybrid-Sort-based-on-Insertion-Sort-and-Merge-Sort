import java.util.Arrays;

public class TimeCompare {
    public static void main(String[] args) {
        // 3 copies of the same array
        int[] testArr1 = GenerateInput.generateRandom(100000, 100);
        
        int[] testArr2 = Arrays.copyOf(testArr1, testArr1.length);
        int[] testArr3 = Arrays.copyOf(testArr1, testArr1.length);
        int[] testArr4 = Arrays.copyOf(testArr1, testArr1.length);

        System.arraycopy(testArr1, 0, testArr2,0, testArr1.length);
        long begin, end, mergeTime1, mergeTime2, insertTime,hybridTime;

        begin = System.currentTimeMillis();
        //begin = System.nanoTime();
        MergeSortInPlace.sortIt(testArr1,0,testArr1.length-1);
        end = System.currentTimeMillis();
        //end = System.nanoTime();
        mergeTime1 = end-begin;

        begin = System.currentTimeMillis();
        //begin = System.nanoTime();
        MergeSortOriginal.sortIt(testArr2,0,testArr2.length-1);
        end = System.currentTimeMillis();
        //end = System.nanoTime();
        mergeTime2 = end-begin;

        begin = System.currentTimeMillis();
        //begin = System.nanoTime();
        InsertionSort.sortIt(testArr3,0,testArr3.length-1);
        end = System.currentTimeMillis();
        //end = System.nanoTime();
        insertTime = end-begin;

        begin = System.currentTimeMillis();
        //begin = System.nanoTime();
        HybridSort.sortIt(testArr4,0,testArr4.length-1);
        end = System.currentTimeMillis();
        //end = System.nanoTime();
        hybridTime = end-begin;

        System.out.println("Time for MergeSort(Inplace) : "+ mergeTime1 + " ms");
        System.out.println("Time for MergeSort(Orignal) : "+ mergeTime2 + " ms");
        System.out.println("Time for InsertionSort: "+ insertTime + " ms");
        System.out.println("Time for HybridSort: "+ hybridTime + " ms");
        System.out.println();
        System.out.println("HybridSort is "+ ((double)hybridTime/(double)mergeTime2) *100+ "% of the original MergeSort");
        
    }
    
}
