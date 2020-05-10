/**
 * https://leetcode-cn.com/problems/add-strings/
 */
public class 字符串相加 {

    class Solution {
        public String addStrings(String num1, String num2) {
            // check
            if ((num1 == null || num1.isEmpty()) && (num2 == null || num2.isEmpty())) {
                return "";
            }
    
            
            char[] c1 = num1.toCharArray();
            char[] c2 = num2.toCharArray();
            int i = c1.length - 1;
            int j = c2.length - 1;
            int plus = 0;
            StringBuilder sb = new StringBuilder();
            while (i >= 0 || j >= 0) {
                int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int sum = n1 + n2 + plus;
                plus = sum / 10;
                sb.append(sum % 10);
                i--;
                j--;
            }
            if (plus > 0) sb.append("1");
            return sb.reverse().toString();
        }
    }
    
}