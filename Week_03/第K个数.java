/**
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 */
public class 第K个数 {
    class Solution {
        public int getKthMagicNumber(int k) {
            // 递归
            // 第k个数，和k-1个数是什么关系
            //
            // 1, 3*1, 5*1, 7*1, 3*3, 3*5, 3*7, 5*5, 5*7, 7*7
            int[] dp = new int[k];
            dp[0] = 1;
            int p3 = 0;
            int p5 = 0;
            int p7 = 0;

            for (int i = 1; i < k; i++) {
                dp[i] = Math.min(dp[p3] * 3, Math.min(dp[p5] * 5, dp[p7] * 7));
                if (dp[i] == dp[p3] * 3)
                    p3++;
                if (dp[i] == dp[p5] * 5)
                    p5++;
                if (dp[i] == dp[p7] * 7)
                    p7++;
            }

            return dp[k - 1];
        }
    }
}