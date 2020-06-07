import java.util.*;

public class _任务调度器 {

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

// 最短时间
// 怎么思考？n是间隔，不同的任务放到不同的地方存
// 思路：在选择任务执行的时候，尽可能去选择已经过了冷却间隔的任务
// 问题：怎么记录一个任务的冷却间隔
// 问题：怎么记录一个任务的剩余个数
    
}