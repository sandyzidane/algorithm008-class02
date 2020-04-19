/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {

        // consider last one less than 9, otherwise equal to 9
        int len = digits.length;

        // search the number less than 9 from right to left,
        // loop stoped until found it
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                continue;
            } else {
                digits[i]++;
                return digits;
            }
        }

        // special case such as [9, 9, 9, 9]
        int[] newArr = new int[len+1];
        newArr[0] = 1;
        return newArr;
    }
}
// @lc code=end

