import java.util.*;

/**
 * _394_字符串解码
 */
public class _394_字符串解码 {

    class Solution {
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            LinkedList<Integer> stackMul = new LinkedList<>();
            LinkedList<String> stackRes = new LinkedList<>();

            char[] chars = s.toCharArray();
            for (Character c : chars) {
                if (c == '[') {
                    stackMul.push(multi);
                    stackRes.push(res.toString());
                    multi = 0;
                    res = new StringBuilder();
                } else if (c == ']') {
                    int mul = stackMul.pop();
                    StringBuilder tmp = new StringBuilder();
                    for (int i = 0; i < mul; i++)
                        tmp.append(res);
                    res = new StringBuilder().append(stackRes.pop() + tmp);
                } else if (c >= '0' && c <= '9')
                    multi = multi * 10 + Integer.parseInt(c + "");
                else
                    res.append(c);
            }

            return res.toString();

        }
    }
}