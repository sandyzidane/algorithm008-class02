package problem;

/**
 * _1014_最佳观光组合
 */
public class _1014_最佳观光组合 {

    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            int ans = 0, mx = A[0] + 0;
            for (int j = 1; j < A.length; j++) {
                ans = Math.max(ans, mx + A[j] - j);
                mx = Math.max(mx, A[j] + j);
            }
            return ans;
        }
    }
    
    // dp?
    // 前缀和?
    // 滑动窗口?
}