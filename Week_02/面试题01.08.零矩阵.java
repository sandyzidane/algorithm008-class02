
/**
* https://leetcode-cn.com/problems/zero-matrix-lcci/
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        // 要的是一个坐标，0元素的横坐标/纵坐标
        // 找到0元素，把位置映射到第一行，第一列
        boolean firstRowSetZero = false, firstColSetZero = false;
        // 行
        int rows = matrix.length, cols = matrix[0].length;

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (matrix[r][c] == 0) {
                    if (r == 0) firstRowSetZero = true;
                    if (c == 0) firstColSetZero = true;
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        for (int r=1; r<rows; r++) {
            if (matrix[r][0] == 0) {
                // set all row to zero
                matrix[r] = new int[cols];
            }
        }

        for (int c=1; c<cols; c++) {
            if (matrix[0][c] == 0) {
                for (int r=1; r<rows; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (firstRowSetZero) {
            matrix[0] = new int[cols];
        }

        if (firstColSetZero) {
            for (int r=0; r<rows; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}