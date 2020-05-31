import java.util.Arrays;

public class _621_任务调度器 {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char t : tasks) {
                map[t - 'A']++;
            }
            Arrays.sort(map);
            int time = 0;
            while (map[25] > 0) {
                int i = 0;
                while (i <= n) {
                    if (map[25] == 0) {
                        break;
                    }
                    if (i < 26 && map[25 - i] > 0) {
                        map[25 - i]--;
                    }
                    time++;
                    i++;
                }
                Arrays.sort(map);
            }
            return time;
        }
    }
}