import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{0, 0};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    // public static void main(String[] args) {
    //     int[] nums = new int[]{2, 7, 11, 15};
    //     int target = 18;

    //     pirntIntArray(new Solution().twoSum(nums, target));
    // }

    // static void pirntIntArray(int[] arr) {
    //     Arrays.stream(arr).forEach(System.out::println);
    // }
}
// @lc code=end

