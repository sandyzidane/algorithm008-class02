/**
 * https://leetcode-cn.com/problems/reverse-string/
 */
/**
 * 翻转字符串
 */
public class 翻转字符串 {
    class Solution {
        public void reverseString(char[] s) {
            if (s.length == 0)
                return;
            swap(s, 0);
        }

        private void swap(char[] s, int index) {
            // terminator
            if (index > (s.length - 1) / 2) {
                return;
            }

            // process
            char tmp = s[index];
            s[index] = s[s.length - index - 1];
            s[s.length - index - 1] = tmp;

            // drill down
            swap(s, index + 1);
        }
    }
}