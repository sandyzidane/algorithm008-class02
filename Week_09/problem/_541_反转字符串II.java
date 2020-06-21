package problem;

/**
 * _541_反转字符串II
 */
public class _541_反转字符串II {

    class Solution {
        public String reverseStr(String s, int k) {
            char[] a = s.toCharArray();
            for (int start = 0; start < a.length; start += 2 * k) {
                int i = start, j = Math.min(start + k - 1, a.length - 1);
                while (i < j) {
                    char tmp = a[i];
                    a[i++] = a[j];
                    a[j--] = tmp;
                }
            }
            return new String(a);
        }
    }
}