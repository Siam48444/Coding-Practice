import java.util.Arrays;

public class FilterArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(evenNumbers(arr)));
        System.out.println(Arrays.toString(oddNumbers(arr)));
    }


    /* Returns a new array containing all the even numbers in the given array
    (using normal array operations) */
    public static int[] evenNumbers(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        }

        // Count the length of the new array
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count += 1;
            }
        }

        // Declare and return the new array with all even numbers
        int[] newArr = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                newArr[index] = num;
                index++;
            }
        }
        return newArr;
    }


    /* Returns a new array containing all the odd numbers in the given array
    (using normal array operations) */
    public static int[] oddNumbers(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        }

        // Count the length of the new array
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                count += 1;
            }
        }

        // Declare and return the new array with all odd numbers
        int[] newArr = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                newArr[index] = num;
                index++;
            }
        }
        return newArr;
    }
}