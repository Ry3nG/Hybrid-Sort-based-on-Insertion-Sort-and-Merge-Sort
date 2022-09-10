

public class TimeCompare {

    public static long mergeInplace(int[] testArrInplace){
        long begin, end;
        begin = System.currentTimeMillis();
        MergeSortInPlace.sortIt(testArrInplace,0,testArrInplace.length-1);
        //end = System.currentTimeMillis();
        end = System.currentTimeMillis();
        return end-begin;
    }

    public static long mergeOriginal(int[] testArrOriginal){
        long begin, end;
        begin = System.currentTimeMillis();
        MergeSortOriginal.sortIt(testArrOriginal,0,testArrOriginal.length-1);
        //end = System.currentTimeMillis();
        end = System.currentTimeMillis();
        return end-begin;
    }

    public static long insertion(int[] testArrInsert){
        long begin, end;
        begin = System.currentTimeMillis();
        InsertionSort.sortIt(testArrInsert,0,testArrInsert.length-1);
        //end = System.currentTimeMillis();
        end = System.currentTimeMillis();
        return end-begin;
    }

    public static long hybrid(int[] testArrHybrid){
        long begin, end;
        begin = System.currentTimeMillis();
        HybridSort.sortIt(testArrHybrid,0,testArrHybrid.length-1);
        //end = System.currentTimeMillis();
        end = System.currentTimeMillis();
        return end-begin;
    }

    public static void main(String[] args) {
        int size = 10000, max = 100;
        // 3 copies of the same array
        int[] testArr1 = GenerateInput.generateRandom(size, max);
        int[] testArr2 = GenerateInput.generateRandom(size, max);
        int[] testArr3 = GenerateInput.generateRandom(size, max);
        int[] testArr4 = GenerateInput.generateRandom(size, max);

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
