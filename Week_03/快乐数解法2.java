/**
 * https://leetcode-cn.com/problems/happy-number/
 */
public class 快乐数解法2 {
    class Solution {
        public boolean isHappy(int n) {
            if (n == 1)
                return true;
            if (n == 0)
                return false;

            // 快慢指针，检测链表是否有循环
            int slow = n;
            int fast = getNext(n);
            while (fast != 1 && fast != slow) {
                slow = getNext(slow);
                fast = getNext(getNext(fast));
            }

            return fast == 1;
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