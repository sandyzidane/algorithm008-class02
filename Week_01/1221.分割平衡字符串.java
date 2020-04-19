/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        int lcnt = 0;
        int rcnt = 0;
        int totalsub = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                lcnt++;
            }
            else {
                rcnt++;
            }

            if (lcnt > 0 && lcnt == rcnt) {
                totalsub++;
                lcnt = 0;
                rcnt = 0;
            }
        }

        return totalsub;

    }
}
// @lc code=end

