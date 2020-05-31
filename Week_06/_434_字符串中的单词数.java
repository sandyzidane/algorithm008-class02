/**
 * _434_字符串中的单词数
 */
public class _434_字符串中的单词数 {

    class Solution {
        public int countSegments(String s) {

            int cnt = 0;
            boolean wordBegin = false;

            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c != ' ') {
                    if (!wordBegin) {
                        cnt++;
                        wordBegin = true;
                    }
                } else {
                    wordBegin = false;
                }
            }

            return cnt;
        }
    }
}