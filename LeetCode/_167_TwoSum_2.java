import java.util.Arrays;


class _167_TwoSum_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum_1(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum_1(new int[] {2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum_1(new int[] {-1, 0}, -1)));
    }


    // Time Complexity = O(n), Space Complexity = O(1)
    public static int[] twoSum_1(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1; 

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }

            if (sum > target) {
                right -= 1;
            }
            else {
                left += 1;
            }
        }

        return new int[] {-1, -1};
    }
}