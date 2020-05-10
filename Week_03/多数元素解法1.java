import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class 多数元素解法1 {
    class Solution {
        public int majorityElement(int[] nums) {
            // 排序，然后取中间一个数
            Arrays.sort(nums);
            int len = nums.length;
            return nums[len / 2];
        }
    }
}