/**
 * _312_戳气球
 */
public class _312_戳气球 {

    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length + 2;
            int[] newNums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                newNums[i + 1] = nums[i];
            }

            newNums[0] = newNums[n - 1] = 1;

            // int[][] memo = new int[n][n];
            // return dp(memo, newNums, 0, n - 1);

            int[][] dp = new int[n][n];

            for (int left = n - 2; left > -1; left--) {
                for (int right = left + 2; right < n; right++) {
                    for (int i = left + 1; i < right; i++) {
                        dp[left][right] = Math.max(dp[left][right],
                                newNums[left] * newNums[i] * newNums[right] + dp[left][i] + dp[i][right]);
                    }
                }
            }

            return dp[0][n - 1];
        }

        private int dp(int[][] memo, int[] nums, int left, int right) {
            if (left + 1 == right)
                return 0;
            if (memo[left][right] > 0)
                return memo[left][right];
            int ans = 0;
            for (int i = left + 1; i < right; i++) {
                int tmp = nums[left] * nums[i] * nums[right] + dp(memo, nums, left, i) + dp(memo, nums, i, right);
                ans = Math.max(ans, tmp);
            }
            memo[left][right] = ans;
            return ans;
        }
    }
}