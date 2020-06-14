package problem;

import java.util.*;

/**
 * _739_每日温度
 */
public class _739_每日温度 {
    
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int len = T.length;
            int[] ans = new int[len];
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                int temperature = T[i];
                while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                    int prevIndex = stack.pop();
                    ans[prevIndex] = i - prevIndex;
                }
                stack.push(i);
            }
            return ans;
        }
    }
}