import java.util.*;

public class _最长连续序列 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n);
            }
            int longStreak = 0;
            for (int n : set) {
                if (!set.contains(n - 1)) {
                    int currentStreak = 1;
                    int currentNum = n;
                    while (set.contains(currentNum + 1)) {
                        currentStreak++;
                        currentNum++;
                    }
                    longStreak = Math.max(longStreak, currentStreak);
                }
            }
            return longStreak;
        }
    }
}