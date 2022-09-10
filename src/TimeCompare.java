import java.util.Arrays;

public class TimeCompare {
    public static void main(String[] args) {
        // 2 copies of the same array
        int[] testArr1 = GenerateInput.generateRandom(500, 1000);
        int[] testArr2 = Arrays.copyOf(testArr1, testArr1.length);


        System.arraycopy(testArr1, 0, testArr2,0, testArr1.length);
        long begin, end, mergeTime, insertTime;
        begin = System.currentTimeMillis();
        MergeSortInPlace.sortIt(testArr1,0,testArr1.length-1);
        end = System.currentTimeMillis();
        mergeTime = end-begin;

        begin = System.currentTimeMillis();
        InsertionSort.sortIt(testArr2,0,testArr2.length-1);
        end = System.currentTimeMillis();
        insertTime = end-begin;

        System.out.println("Time for MergeSort : "+ mergeTime + " ms");
        System.out.println("Time for InsertionSort: "+ insertTime + " ms");
        
    }
    
}
