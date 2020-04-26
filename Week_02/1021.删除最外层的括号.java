import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1021 lang=java
 *
 * [1021] 删除最外层的括号
 */

// @lc code=start
class Solution {
    public String removeOuterParentheses(String S) {
        int opend = 0;

        StringBuilder builder = new StringBuilder();

        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(' && opend++ > 0) builder.append(c);
            if (c == ')' && opend-- > 1) builder.append(c);
        }

        return builder.toString();
    }
}
// @lc code=end

