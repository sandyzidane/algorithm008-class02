
public class _最大正方形 {

    class Solution {
        public int maximalSquare(char[][] matrix) {
            int row = matrix.length;
            if (row == 0) return 0;
            int col = matrix[0].length;
            if (col == 0) return 0;

            // dp[i][j]的含义：矩阵中的以[i, j]为右下角，只包含1的正方形的最大边长
            // 状态转移方程：dp[i][j] = 三种情况
            // 情况1: matrix[i][j] == '0' => dp[i][j] = 0
            // 情况2: matrix[i][j] == '1' 且在边缘(i == 0 || j == 0) => dp[i][j] = 1
            // 情况3: matrix[i][j] == '1' => dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
            int[][] dp = new int[row][col];
            int maxSide = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == '1') {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                        }
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            return maxSide * maxSide;
        }
    }
    
}