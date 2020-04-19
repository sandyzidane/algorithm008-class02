/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }

        // dual pointers
        int len = A.length;
        int left = 0, right = len - 1;
        int[] result = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                result[i] = A[left] * A[left];
                left++;
            } else {
                result[i] = A[right] * A[right];
                right--;
            }
        }

        return result;
    }
}
// @lc code=end

