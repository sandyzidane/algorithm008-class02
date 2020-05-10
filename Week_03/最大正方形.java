/**
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class 最大正方形 {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            // check
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return 0;

            int row = matrix.length, col = matrix[0].length;

            int maxSquare = 0;

            int[][] dp = new int[row][col];

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (matrix[r][c] == '1') {
                        if (r == 0 || c == 0) {
                            dp[r][c] = 1;
                        } else {
                            dp[r][c] = Math.min(dp[r - 1][c], Math.min(dp[r - 1][c - 1], dp[r][c - 1])) + 1;
                        }
                        maxSquare = Math.max(maxSquare, dp[r][c]);
                    }
                }
            }

            return maxSquare * maxSquare;
        }
    }
}