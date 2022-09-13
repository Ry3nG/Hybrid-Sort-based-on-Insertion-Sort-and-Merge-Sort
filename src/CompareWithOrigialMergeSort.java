public class CompareWithOrigialMergeSort {
    public static void main(String[] args) {
        long[] mergesortResults = new long[2];
        long[] hybridsortResults = new long[2];
        mergesortResults = MergeSortwithKeyCmp.getMergeSortKeyCmpandTime();
        hybridsortResults = HybridSortwithKeyCmp.getHybridSortKeyCmpandTime();

        System.out.println();
        System.out.println("Average keyCmp for MergeSort: " + mergesortResults[0]);
        System.out.println("Average CPU Time for MergeSort: " + mergesortResults[1] + "ms");
        System.out.println();
        System.out.println("Average keyCmp for HybridSort: " + hybridsortResults[0]);
        System.out.println("Average CPU Time for HybridSort: " + hybridsortResults[1] + "ms");

    }
}
