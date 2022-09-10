import java.util.Arrays;

public class TimeCompare {
    public static void main(String[] args) {
        // 3 copies of the same array
        int[] testArr1 = GenerateInput.generateRandom(30, 100);
        int[] testArr2 = Arrays.copyOf(testArr1, testArr1.length);
        int[] testArr3 = Arrays.copyOf(testArr1, testArr1.length);

        System.arraycopy(testArr1, 0, testArr2,0, testArr1.length);
        long begin, end, mergeTime1, mergeTime2, insertTime;

        //begin = System.currentTimeMillis();
        begin = System.nanoTime();
        MergeSortInPlace.sortIt(testArr1,0,testArr1.length-1);
        //end = System.currentTimeMillis();
        end = System.nanoTime();
        mergeTime1 = end-begin;

        //begin = System.currentTimeMillis();
        begin = System.nanoTime();
        MergeSortOriginal.sortIt(testArr2,0,testArr2.length-1);
        //end = System.currentTimeMillis();
        end = System.nanoTime();
        mergeTime2 = end-begin;

        //begin = System.currentTimeMillis();
        begin = System.nanoTime();
        InsertionSort.sortIt(testArr3,0,testArr3.length-1);
        //end = System.currentTimeMillis();
        end = System.nanoTime();
        insertTime = end-begin;

        System.out.println("Time for MergeSort(Inplace) : "+ mergeTime1 + " ns");
        System.out.println("Time for MergeSort(Orignal) : "+ mergeTime2 + " ns");
        System.out.println("Time for InsertionSort: "+ insertTime + " ns");
        
    }
    
}
