/**
 * 152. 乘积最大子数组
 */
public class _152_乘积最大子数组 {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, -2, 4 };
        System.out.println(new _152_乘积最大子数组().new Solution().maxProduct(nums));
    }

    class Solution {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            int[] maxF = new int[len], minF = new int[len];
            maxF[0] = nums[0];
            minF[0] = nums[0];
            for (int i = 1; i < len; i++) {
                maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
                minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            }

            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                ans = Math.max(ans, maxF[i]);
            }
            return ans;
        }
    }
}