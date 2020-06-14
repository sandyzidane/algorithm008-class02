package problem;

import java.util.*;

/**
 * _127_单词接龙
 */
public class _127_单词接龙 {

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
            Set<String> wordSet = new HashSet<>(wordList);
            if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
                return 0;
            }
    
            // 标准写法，总的 visited 数组
            Set<String> visited = new HashSet<>();
    
            // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列
            Set<String> beginVisited = new HashSet<>();
            beginVisited.add(beginWord);
    
            Set<String> endVisited = new HashSet<>();
            endVisited.add(endWord);
    
            
            int step = 1;
            while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
                if (beginVisited.size() > endVisited.size()) {
                    Set<String> temp = beginVisited;
                    beginVisited = endVisited;
                    endVisited = temp;
                }
    
                // nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
                Set<String> nextLevelVisited = new HashSet<>();
                for (String word : beginVisited) {
                    char[] charArray = word.toCharArray();
                    for (int i = 0; i < charArray.length; i++) {
                        char currentChar = charArray[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (charArray[i] == c) {
                                continue;
                            }
                            charArray[i] = c;
                            String nextWord = String.valueOf(charArray);
                            if (wordSet.contains(nextWord)) {
                                if (endVisited.contains(nextWord)) {
                                    return step + 1;
                                }
                                if (!visited.contains(nextWord)) {
                                    nextLevelVisited.add(nextWord);
                                    visited.add(nextWord);
                                }
                            }
                        }
                        // 恢复，下次再用
                        charArray[i] = currentChar;
                    }
                }
    
                // 这一行代表表示从 begin 这一侧向外扩散了一层
                beginVisited = nextLevelVisited;
                step++;
            }
            return 0;
        }
    }

    
}