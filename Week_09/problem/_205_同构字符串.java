package problem;

import java.util.*;
/**
 * _205_同构字符串
 */
public class _205_同构字符串 {

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
        }

        private boolean isIsomorphicHelper(String s, String t) {
            int len1 = s.length(), len2 = t.length();
            if (len1 != len2)
                return false;

            Map<Character, Character> map = new HashMap<>();

            for (int i = 0; i < len1; i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);

                if (map.containsKey(c1)) {
                    if (map.get(c1) != c2) {
                        return false;
                    }
                } else {
                    map.put(c1, c2);
                }
            }
            return true;
        }
    }
}