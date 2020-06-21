package problem;

import java.util.*;
/**
 * _438_找到字符串中所有字母异位词
 */
public class _438_找到字符串中所有字母异位词 {

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : p.toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);
            Map<Character, Integer> window = new HashMap<>();

            int left = 0, right = 0, valid = p.length();
            while (right < s.length()) {
                char r = s.charAt(right);
                if (map.containsKey(r)) {
                    window.put(r, window.getOrDefault(r, 0) + 1);
                    // 只有当window中该有效字符数量不大于map中该字符数量，才能算一次有效包含
                    if (window.get(r) <= map.get(r)) {
                        valid--;
                    }
                }

                while (valid == 0) {
                    if (right - left + 1 == p.length())
                        res.add(left);
                    char l = s.charAt(left);
                    if (map.containsKey(l)) {
                        window.put(l, window.get(l) - 1);
                        if (window.get(l) < map.get(l)) {
                            valid++;
                        }
                    }
                    left++;
                }
                right++;
            }
            return res;

        }
    }

    // 滑动窗口
}