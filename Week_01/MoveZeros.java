/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        // solution 1, with many operations
        // int insertPos = 0;
        // for (int num : nums) {
        //   if (num != 0) {
        //     nums[insertPos++] = num;
        //   }
        // }
        // while (insertPos < nums.length) {
        //   nums[insertPos++] = 0;
        // }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

    }
}
// @lc code=end
