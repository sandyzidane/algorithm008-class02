/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {

        int area = 0;

        int left = 0, right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            area = Math.max(area, width * minHeight);
            // 左侧高度低，往右找
            if (height[left] < height[right]) {
                left++;
            }
            // 右侧高度低，往左找
            else {
                right--;
            }
        }

        return area;

    }
}
// @lc code=end

