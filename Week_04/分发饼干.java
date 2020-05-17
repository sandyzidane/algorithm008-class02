import java.util.Arrays;

public class 分发饼干 {

    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            if (g.length == 0 || s.length == 0)
                return 0;
            Arrays.sort(g);
            Arrays.sort(s);

            // gp记录小朋友的位置，sp记录饼干的位置，cnt记录已满足的小朋友个数
            int gp = 0, sp = 0, cnt = 0;
            while (gp < g.length && sp < s.length) {
                if (g[gp] <= s[sp]) {
                    cnt++;
                    gp++;
                    sp++;
                } else {
                    // 满足不了小朋友的胃口了
                    while (sp < s.length && g[gp] > s[sp])
                        sp++;
                }
            }

            return cnt;
        }
    }

}