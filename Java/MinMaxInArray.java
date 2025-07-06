import java.util.Arrays;


public class MinMaxInArray {
    public static void main(String[] args) {
        int[] arr = {};

        int minimum = minValue(arr);
        System.out.println(minimum);

        int maximum = maxValue(arr);
        System.out.println(maximum);
    }


    // Returns the minimum integer is an array
    public static int minValue(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        return smallest;
    }


    // Returns the maximum integer is an array
    public static int maxValue(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }
}