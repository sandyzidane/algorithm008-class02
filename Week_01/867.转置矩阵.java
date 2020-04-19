/*
 * @lc app=leetcode.cn id=867 lang=java
 *
 * [867] 转置矩阵
 */

// @lc code=start
class Solution {
    public int[][] transpose(int[][] A) {

        int origRows = A.length;
        int origCols = A[0].length;

        int[][] result = new int[origCols][origRows];
        for (int i=0; i<origCols; i++) {
            for (int j=0; j<origRows; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }
}
// @lc code=end

