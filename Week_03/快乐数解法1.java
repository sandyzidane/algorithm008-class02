import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/happy-number/
 */
public class 快乐数解法1 {
    class Solution {
        public boolean isHappy(int n) {
            if (n == 1)
                return true;
            if (n == 0)
                return false;
            // 循环
            Set<Integer> set = new HashSet<>();
            while (n != 1 && !set.contains(n)) {
                set.add(n);
                n = getNext(n);
            }

            return n == 1;

        }

        int getNext(int n) {
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                sum += d * d;
                n = n / 10;
            }
            return sum;
        }
    }
}