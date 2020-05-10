/**
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class x的平方根 {
    class Solution {
        public int mySqrt(int x) {
            if (x < 1)
                return 0;

            int left = 1, right = x;
            while (left <= right && left + 1 < right) {
                int mid = left + (right - left) / 2;
                int t = x / mid;
                if (t == mid)
                    return mid;
                else if (t < mid)
                    right = mid;
                else if (t > mid)
                    left = mid;
            }
            return left;
        }
    }
}