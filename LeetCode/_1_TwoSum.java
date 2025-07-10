import java.util.Arrays;
import java.util.HashMap;


class _1_TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum_2(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum_2(new int[] {3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum_2(new int[] {3, 3}, 6)));
    }


    // Time Complexity = O(n^2), Space Complexity = O(1)
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


    // Time Complexity = O(), Space Complexity = O()
    public static int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();   // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}