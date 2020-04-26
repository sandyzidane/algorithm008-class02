/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int idxS = 0, idxT = 0;
        if (s.length() == 0) return true;

        while (idxT < t.length()) {
            if (s.charAt(idxS) == t.charAt(idxT)) {
                idxS++;
                if (idxS == s.length()) return true;
            }
            idxT++;
        }
        return false;
    }
}
// @lc code=end

