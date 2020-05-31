/**
 * 680. 验证回文字符串II
 */
public class _680_验证回文字符串II {

    class Solution {
        public boolean validPalindrome(String s) {
            int l = -1, r = s.length();
            while (++l < --r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return isPalindromic(s, l - 1, r)
                        || isPalindromic(s, l, r + 1);
                }
            }
            return true;
        }

        public boolean isPalindromic(String s, int l, int r) {
            while (++l < --r) {
                if (s.charAt(l) != s.charAt(r)) return false;
            }
            return true;
        }
    }
    
}