

public class MergeSortOriginal {

    public static void  sortIt(int[] anyArray, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            sortIt(anyArray, start, mid);
            sortIt(anyArray, mid + 1, end);

            merge(anyArray, start, mid, end);
        }
    }

    public static void  merge(int[] anyArray, int start, int mid, int end) {

        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = anyArray[start + i];
        for (int j = 0; j < n2; ++j)
            R[j] = anyArray[mid + 1 + j];

        int i = 0, j = 0;
        int k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                anyArray[k] = L[i];
                i++;
            } else {
                anyArray[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            anyArray[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            anyArray[k] = R[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {

    }
}
