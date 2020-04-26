import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k * n == 0)
            return new int[0];
        if (k == 1)
            return nums;

        MonotonicQueue window = new MonotonicQueue();
        int[] r = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                r[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }
        return r;
    }

    class MonotonicQueue {
        Deque<Integer> deq = new ArrayDeque<>();

        void push(int n) {
            while (!deq.isEmpty() && deq.getLast() < n) {
                deq.removeLast();
            }
            deq.addLast(n);
        }

        int max() {
            return deq.getFirst();
        }

        void pop(int n) {
            if (!deq.isEmpty() && deq.getFirst() == n) {
                deq.removeFirst();
            }
        }
    }
}