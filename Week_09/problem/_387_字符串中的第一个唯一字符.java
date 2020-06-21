package problem;

import java.util.*;
/**
 * _387_字符串中的第一个唯一字符
 */
public class _387_字符串中的第一个唯一字符 {

    class Solution {
        public int firstUniqChar(String s) {
            int[] cnt = new int[26];
            Arrays.fill(cnt, 0);

            // check
            int len = s.length();
            char[] chars = s.toCharArray();
            if (len == 0)
                return -1;

            // first loop
            for (int i = 0; i < len; i++) {
                cnt[chars[i] - 'a']++;
            }

            // second loop
            for (int i = 0; i < len; i++) {
                if (cnt[chars[i] - 'a'] == 1)
                    return i;
            }

            return -1;
        }
    }

    // map, treemap, char[], int[]
}