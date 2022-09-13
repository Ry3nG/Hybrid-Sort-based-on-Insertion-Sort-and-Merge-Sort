import java.util.*;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] testArr = { 3,99,5 };
        sortIt(testArr, 0, testArr.length - 1);
        System.out.println(Arrays.toString(testArr));
    }

    public static void sortIt(int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        if ((mid - start) <= 0)
        {
            if(arr[start] > arr[end])
                swap(arr,start,end);
            return;
        }
        else if ((end - start) > 1) {
            sortIt(arr, start, mid);
            sortIt(arr, mid + 1, end);
        }
        merge(arr, start, end);

    }

    public static void merge(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        int a = start, b = mid + 1;
        int temp,i;

        if ((end - start) <= 0)
            return;
        while (a <= mid && b <= end) {
            if (arr[a] < arr[b]) {
                a++;
            } else {
                temp = arr[b];
                for(i = b;i>a;i--){
                    arr[i] = arr[i-1];
                }
                arr[a] = temp;
                a++;mid++;b++;
            }
        }

    }
    public static void swap(int[] arr, int i,int j){
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
}