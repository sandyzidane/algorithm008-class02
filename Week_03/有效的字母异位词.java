import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class 有效的字母异位词 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null)
                return false;
            int sLen = s.length(), tLen = t.length();
            if (sLen != tLen)
                return false;

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < sLen; i++) {
                map.compute(s.charAt(i), (k, v) -> (v == null) ? 1 : v + 1);
            }
            for (int i = 0; i < tLen; i++) {
                if (!map.containsKey(t.charAt(i))) {
                    return false;
                }
                map.compute(t.charAt(i), (k, v) -> v - 1);
            }
            return map.values().stream().allMatch(v -> v == 0);
        }
    }
}