import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,4,5,2,4,6,11,8,9};
        sortIt(arr);
        System.out.println(Arrays.toString(arr));
        
    }
    public static void sortIt(int[] arr){
        int n = arr.length;
        for(int i = 1; i<n; i++){
            for(int j = i; j>0; j--){
                if(arr[j]<arr[j-1])
                    swap(arr, j,j-1);
                else
                    break;
            }
        }
    }
    public static void swap(int[] arr, int i,int j){
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
}
