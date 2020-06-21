package problem;


/**
 * _300_最长上升子序列
 */
public class _300_最长上升子序列 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0)
                return 0;

            int[] dp = new int[nums.length];
            dp[0] = 1;

            for (int i = 0; i < nums.length; i++) {
                // 对于j(0 -> i)，取符合条件：nums[i] > nums[j]中的最大的dp[j]
                int maxval = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        maxval = Math.max(maxval, dp[j]);
                    }
                }
                dp[i] = maxval + 1;
            }

            int maxans = 1;
            for (int n : dp) {
                maxans = Math.max(maxans, n);
            }
            return maxans;
        }
    }

    // 上升子序列，单调栈吗？
    // 每个元素，要找之后比他更大的元素个数
}
