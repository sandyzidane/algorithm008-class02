import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _127_单词接龙 {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // 广度优先
            // queue, visited

            if (beginWord.equals(endWord))
                return 0;

            Set<String> wordSet = new HashSet<>(wordList);

            int level = 1;
            Queue<String> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            q.offer(beginWord);
            visited.add(beginWord);

            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    String cur = q.poll();
                    if (cur.equals(endWord))
                        return level;

                    char[] chars = cur.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        char old = chars[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            chars[i] = c;
                            String tmpS = new String(chars);
                            if (!visited.contains(tmpS) && wordSet.contains(tmpS)) {
                                q.offer(tmpS);
                                visited.add(tmpS);
                            }
                        }
                        chars[i] = old;
                    }
                }
                level++;
            }
            return 0;
        }
    }
}