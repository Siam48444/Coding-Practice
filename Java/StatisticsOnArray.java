import java.util.Arrays;


public class StatisticsOnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Array   : " + Arrays.toString(arr));
        System.out.println("Minimum : " + minValue(arr));
        System.out.println("Maximum : " + maxValue(arr));
        System.out.println("Sum     : " + sum(arr));
        System.out.printf("Average: %.2f %n", avg(arr));
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


    // Returns the sum of all integers in an array
    public static int sum(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int total = 0;
        for (int n : arr) {
            total += n;
        }
        return total;
    }


    // Returns the average (float) of all integers in an array
    public static float avg(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        float total = sum(arr);
        return total / arr.length;
    }
}