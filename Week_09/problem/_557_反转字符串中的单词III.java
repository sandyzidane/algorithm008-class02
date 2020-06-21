package problem;

/**
 * _557_反转字符串中的单词III
 */
public class _557_反转字符串中的单词III {

    class Solution {
        public String reverseWords(String s) {

            char[] chars = s.toCharArray();
            int wordStart = 0, wordEnd = 0;

            while (wordEnd < chars.length) {
                while (wordEnd < chars.length && chars[wordEnd] != ' ')
                    wordEnd++;
                reverse(chars, wordStart, wordEnd - 1);
                // 此时wordEnd是空格，下一个空格啦
                wordStart = wordEnd + 1;
                wordEnd++;
            }

            return new String(chars);
        }

        public void reverse(char[] s, int start, int end) {
            while (start < end) {
                char tmp = s[start];
                s[start++] = s[end];
                s[end--] = tmp;
            }
        }

    }

    // l, r 滚动更新，要有新的变量，来记录当前单词的结束位置
}