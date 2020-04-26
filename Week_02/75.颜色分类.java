/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int p0 = 0, p2 = len - 1, cur = 0;

        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, cur, p0);
                cur++;
                p0++;
            }
            else if (nums[cur] == 2) {
                swap(nums, cur, p2);
                p2--;
            } else if (nums[cur] == 1) {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

