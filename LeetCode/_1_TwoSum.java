import java.util.Arrays;

class _1_TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;

        int[] nums2 = {3,2,4};
        int target2 = 6;

        int[] nums3 = {3,3};
        int target3 = 6;

        System.out.println(Arrays.toString(twoSum_1(nums1, target1)));
        System.out.println(Arrays.toString(twoSum_1(nums2, target2)));
        System.out.println(Arrays.toString(twoSum_1(nums3, target3)));
    }


    public static int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}