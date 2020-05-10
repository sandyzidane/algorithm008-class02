import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class 无重复字符的最长字串 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();

            int rk = -1, ans = 0;
            int n = s.length();
            for (int i = 0; i < s.length(); i++) {
                if (i != 0) {
                    set.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                    set.add(s.charAt(rk + 1));
                    rk++;
                }
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }

    }

}