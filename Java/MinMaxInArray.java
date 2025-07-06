import java.util.Arrays;


public class MinMaxInArray {
    public static void main(String[] args) {
        int[] arr = {5, 8, 12, 3, 9};

        int small = minValue(arr);
        System.out.println(small);
    }


    // Finds the minimum number is an array
    public static int minValue(int[] arr) {
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        return smallest;
    }
}