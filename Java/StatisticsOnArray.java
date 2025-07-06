import java.util.Arrays;


public class StatisticsOnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int minimum = minValue(arr);
        System.out.println(minimum);

        int maximum = maxValue(arr);
        System.out.println(maximum);
    }


    // Returns the minimum integer in an array
    public static int minValue(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int smallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                smallest = num;
            }
        }

        return smallest;
    }


    // Returns the maximum integer in an array
    public static int maxValue(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int largest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }

        return largest;
    }
}