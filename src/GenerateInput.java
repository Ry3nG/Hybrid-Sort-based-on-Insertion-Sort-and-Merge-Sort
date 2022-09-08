
/*
 * Generate arrays of increasing sizes, in a range from 1,000 to 10 million. 
 * For each of the sizes, generate a random dataset of integers
 * in the range of [1, …, x], where x is the largest number you allow for your datasets.
 */
import java.util.*;

public class GenerateInput {
    public static void main(String[] args) {
        int[] testArr = generateRandom(10, 100);
        System.out.println(Arrays.toString(testArr));

    }

    public static int[] generateRandom(int size, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            /*java random returns a pseudorandom,
            uniformly distributed int value between 0 (inclusive) and the specified value (exclusive)*/
            arr[i] = new Random().nextInt(max-1+1)+1; 
        return arr;
    }

}
