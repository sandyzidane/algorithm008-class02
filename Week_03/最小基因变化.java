import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class 最小基因变化 {
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            if (start.equals(end))
                return 0;

            Set<String> bankSet = new HashSet<>();
            for (String b : bank)
                bankSet.add(b);

            char[] charset = new char[] { 'A', 'C', 'G', 'T' };

            int level = 0;
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    String curr = queue.poll();
                    if (curr.equals(end))
                        return level;

                    char[] currArray = curr.toCharArray();
                    for (int i = 0; i < currArray.length; i++) {
                        char old = currArray[i];
                        for (char c : charset) {
                            currArray[i] = c;
                            String next = new String(currArray);
                            if (!visited.contains(next) && bankSet.contains(next)) {
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                        currArray[i] = old;
                    }
                }
                level++;
            }
            return -1;
        }
    }
}