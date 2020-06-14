package problem;

/**
 * _231_2的幂
 */
public class _231_2的幂 {

    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
    
}