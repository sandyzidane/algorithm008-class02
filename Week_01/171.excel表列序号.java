/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        // 26进制
        char[] chars = s.toCharArray();
        int len = chars.length;

        int sum = 0;
        for (int i=0; i<len; i++) {
            int num = chars[len - i - 1] - 64;
            sum += num * exp(26, i);
        }

        return sum;
    }

    private static int exp(int base, int n) {
        int result = 1;
        for (int i=0; i<n; i++) {
            result *= base;
        }
        return result;
    }
}
// @lc code=end

