/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class 多数元素解法2 {
    class Solution {
        public int majorityElement(int[] nums) {
            // moore voting
            int cnt = 1, maj = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (cnt == 0) {
                    cnt++;
                    maj = nums[i];
                } else {
                    cnt += (nums[i] == maj ? 1 : -1);
                }
            }
            return maj;
        }
    }
}