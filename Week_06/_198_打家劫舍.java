/**
 * _198_打家劫舍
 */
public class _198_打家劫舍 {

    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;

            if (len == 0)
                return 0;

            int[] dp = new int[len + 1];

            // dp[i] = max(dp(i-2) + A[i], dp[i-1])
            dp[0] = 0;
            dp[1] = nums[0];

            for (int i = 2; i <= len; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }

            return dp[len];
        }
    }
}