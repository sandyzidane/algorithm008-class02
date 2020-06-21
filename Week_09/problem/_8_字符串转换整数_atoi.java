package problem;

/**
 * _8_字符串转换整数_atoi
 */
public class _8_字符串转换整数_atoi {

    class Solution {
        public int myAtoi(String str) {
            if (str == null || str.length() == 0)
                return 0;
            int idx = 0, n = str.length();
            while (idx < n && str.charAt(idx) == ' ') {
                idx++;
            }
            if (idx == n)
                return 0;

            int sign = 1;
            if (str.charAt(idx) == '+') {
                sign = 1;
                idx++;
            } else if (str.charAt(idx) == '-') {
                sign = -1;
                idx++;
            } else if (!Character.isDigit(str.charAt(idx))) {
                return 0;
            }

            int ans = 0;
            while (idx < n && Character.isDigit(str.charAt(idx))) {
                int digit = str.charAt(idx) - '0';
                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans * 10 + digit;
                idx++;
            }
            return sign * ans;
        }
    }
}