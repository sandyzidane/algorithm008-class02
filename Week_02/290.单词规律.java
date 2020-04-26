import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");

        System.out.println(pattern.length());
        System.out.println(arr.length);

        if (pattern.length() != arr.length) {
            return false;
        }

        Map<Character, Integer> pmap = new HashMap<>();
        Map<String, Integer> smap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!Objects.equals(pmap.put(pattern.charAt(i), i), smap.put(arr[i], i))) {
                return false;
            }
        }

        return true;
    }
    // public boolean wordPattern(String pattern, String str) {
    //     String[] words = str.split(" ");
    //     if (words.length != pattern.length())
    //         return false;
    //     Map index = new HashMap();
    //     for (Integer i=0; i<words.length; ++i)
    //         if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
    //             return false;
    //     return true;
    // }
}
// @lc code=end

