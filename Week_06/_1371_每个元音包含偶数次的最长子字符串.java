import java.util.HashMap;
import java.util.Map;

public class _1371_每个元音包含偶数次的最长子字符串 {
    class Solution {
        public int findTheLongestSubstring(String s) {

            int res = 0, cur = 0, n = s.length();

            Map<Integer, Integer> seen = new HashMap<>();
            seen.put(0, -1);

            for (int i = 0; i < n; i++) {
                cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1;
                seen.putIfAbsent(cur, i);
                res = Math.max(res, i - seen.get(cur));
            }

            return res;
        }
    }
}