package problem;

/**
 * _70_爬楼梯
 */
public class _70_爬楼梯 {

    class Solution {
        public int climbStairs(int n) {
            int len = Math.max(n+1, 3);
            int[] dp = new int[len];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <=n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }
    
}