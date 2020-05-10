/**
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class 丑数解法1 {
    class Solution {
        public int nthUglyNumber(int n) {
            // 只包含2、3、5作为因子
            int[] dp = new int[n + 1];

            dp[0] = 1;
            // 记录只乘2，只乘3，只乘5的位置，一开始都在第1个元素的位置
            int p2 = 0;
            int p3 = 0;
            int p5 = 0;

            for (int i = 1; i <= n; i++) {
                dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
                if (dp[i] == dp[p2] * 2)
                    p2++;
                if (dp[i] == dp[p3] * 3)
                    p3++;
                if (dp[i] == dp[p5] * 5)
                    p5++;
            }

            return dp[n - 1];
        }
    }
}