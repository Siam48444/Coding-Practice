import java.util.Arrays;


public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {5, 8, 12, 3, 9};

        int secondLargest = secondLargestNumber(arr);
        System.out.println(secondLargest);
    }


    public static int secondLargestNumber(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
}