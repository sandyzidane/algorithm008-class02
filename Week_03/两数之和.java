import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class 两数之和 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // map存储 数值和位置
            Map<Integer, Integer> map = new HashMap<>();
            // List<Integer> r = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                    return new int[] { map.get(target - nums[i]), i };
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }
}