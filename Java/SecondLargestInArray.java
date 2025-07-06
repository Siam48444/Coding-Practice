import java.util.Arrays;


public class SecondLargestInArray {
    public static void main(String[] args) {
        int[] arr = {5, 8, 12, 3, 9};

        int secondLargest = secondLargestNumber(arr);
        System.out.println(secondLargest);
    }


    // Method to find the second largest number in an array
    public static int secondLargestNumber(int[] arr) {
        // Initialize both largest and secondLargest with the smallest possible integer
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;  // Old largest becomes second largest
                largest = arr[i];         // New largest found
            }
            else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];   // Update secondLargest
            }
        }

        return secondLargest;
    }
}