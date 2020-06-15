package problem;

/**
 * _14_最长公共前缀
 */
public class _14_最长公共前缀 {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
    
            String ans = strs[0];
            for (String s : strs) {
                int j = 0;
                for (; j < ans.length() && j < s.length(); j++) {
                    if (ans.charAt(j) != s.charAt(j)) {
                        break;
                    }
                }
                ans = ans.substring(0, j);
                if (ans.equals("")) return ans;
            }
    
            return ans;
        }
    }
    
    // 转换成26叉树吗？然后找最小深度 字典树
    // map?
    
}