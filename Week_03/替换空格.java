/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class 替换空格 {
    class Solution {
        public String replaceSpace(String s) {
            if (s == null || s.isEmpty()) return s;
            char[] ch = s.toCharArray();
            char[] newch = new char[ch.length * 3];
            int size = 0;
            for (int i=0; i<ch.length; i++) {
                if (ch[i] == ' ') {
                    newch[size] = '%';
                    newch[size+1] = '2';
                    newch[size+2] = '0';
                    size += 3;
                } else {
                    newch[size] = ch[i];
                    size += 1;
                }
            }
            return new String(newch, 0, size);
        }
    }
}