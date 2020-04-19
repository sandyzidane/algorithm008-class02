/*
 * @lc app=leetcode.cn id=1281 lang=java
 *
 * [1281] 整数的各位积和之差
 */

// @lc code=start
class Solution {
    public int subtractProductAndSum(int n) {
        // 模10得到最后一位，再除10去掉最后一位
        // 10以内差肯定是0
        if (n < 10) {
            return 0;
        }

        int product = 1;
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            product *= lastDigit;
            sum += lastDigit;
            n = n / 10;
        }
        return product - sum;
    }
}
// @lc code=end

