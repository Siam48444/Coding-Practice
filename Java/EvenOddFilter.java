import java.util.Arrays;
import java.util.ArrayList;

public class EvenOddFilter {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(getEvenNumbersNewVersion(arr)));
        System.out.println(Arrays.toString(getOddNumbersNewVersion(arr)));
    }


    public static int[] getEvenNumbers(int[] arr) {
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


    public static int[] getOddNumbers(int[] arr) {
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


    public static int[] getEvenNumbersNewVersion(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        }

        // Step 1: Use ArrayList to collect even numbers
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 == 0) {
                list.add(num);
            }
        }

        // Step 2: Convert ArrayList to int[]
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        // Step 3: Return the array
        return result;
    }


    public static int[] getOddNumbersNewVersion(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        }

        // Step 1: Use ArrayList to collect odd numbers
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 != 0) {
                list.add(num);
            }
        }

        // Step 2: Convert ArrayList to int[]
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        // Step 3: Return the array
        return result;
    }
}