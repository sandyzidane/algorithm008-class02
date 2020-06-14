package problem;

/**
 * _191_位1的个数
 */
public class _191_位1的个数 {

    class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int cnt = 0;
            while (n != 0) {
                n = n & (n - 1);
                cnt++;
            }
            return cnt;
        }
    }
    
}