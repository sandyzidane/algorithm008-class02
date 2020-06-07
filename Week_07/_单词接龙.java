import java.util.*;

import javafx.util.Pair;

public class _单词接龙 {

    class TwoEndedBFSSolution {

        int len = 0;
        Map<String, List<String>> comboMap = new HashMap<>();
    
        public int ladderLength(final String beginWord, final String endWord, final List<String> wordList) {
            if (!wordList.contains(endWord))
                return 0;
            this.len = beginWord.length();
            for (String word : wordList) {
                for (int i = 0; i < this.len; i++) {
                    String tmp = changeCharAt(word, i, '*');
                    comboMap.compute(tmp, (k, oldV) -> {
                        if (oldV == null) oldV = new ArrayList<>();
                        oldV.add(word);
                        return oldV;
                    });
                }
            }
    
            Queue<Pair<String, Integer>> qBegin = new LinkedList<>();
            Queue<Pair<String, Integer>> qEnd = new LinkedList<>();
            qBegin.offer(new Pair<>(beginWord, 1));
            qEnd.offer(new Pair<>(endWord, 1));
            Map<String, Integer> visitedBegin = new HashMap<>();
            Map<String, Integer> visitedEnd = new HashMap<>();
            visitedBegin.put(beginWord, 1);
            visitedEnd.put(endWord, 1);
    
            while (!qBegin.isEmpty() && !qEnd.isEmpty()) {
                // 从begin方向走一步
                int ans = visitWordNode(qBegin, visitedBegin, visitedEnd);
                if (ans > -1) {
                    return ans;
                }
    
                // 从end方向走一步
                ans = visitWordNode(qEnd, visitedEnd, visitedBegin);
                if (ans > -1) {
                    return ans;
                }
            }
            return 0;
        }
    
        private int visitWordNode(Queue<Pair<String, Integer>> q, 
                                    Map<String, Integer> visited, 
                                    Map<String, Integer> otherVisited) {
            Pair<String, Integer> p = q.poll();
            String word = p.getKey();
            Integer level = p.getValue();
    
            for (int i = 0; i < this.len; i++) {
                String newWord = changeCharAt(word, i, '*');
    
                for (String ajacentWord : comboMap.getOrDefault(newWord, new ArrayList<>())) {
                    if (otherVisited.containsKey(ajacentWord)) {
                        return level + otherVisited.get(ajacentWord);
                    }
                    if (!visited.containsKey(ajacentWord)) {
                        visited.put(ajacentWord, level + 1);
                        q.offer(new Pair<>(ajacentWord, level + 1));
                    }
                }
            }
            return -1;
        }
    
        private String changeCharAt(final String s, final int index, final char c) {
            final char[] chars = s.toCharArray();
            chars[index] = c;
            return new String(chars);
        }
    }

    class BFSSolution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int len = beginWord.length();
            Map<String, List<String>> comboMap = new HashMap<>();
            for (String word : wordList) {
                for (int i = 0; i < len; i++) {
                    String tmp = changeChatAt(word, i, '*');
                    comboMap.compute(tmp, (k, oldV) -> {
                        if (oldV == null) oldV = new ArrayList<>();
                        oldV.add(word);
                        return oldV;
                    });
                }
            }
    
            Set<String> visited = new HashSet<>();
            Queue<Pair<String, Integer>> q = new LinkedList<>();
            q.offer(new Pair<>(beginWord, 1));
    
            while (!q.isEmpty()) {
                Pair<String, Integer> p = q.poll();
                String word = p.getKey();
                Integer level = p.getValue();
                for (int i = 0; i < len; i++) {
                    String newWord = changeChatAt(word, i, '*');
                    for (String ajacentWord : comboMap.getOrDefault(newWord, new ArrayList<>())) {
                        if (ajacentWord.equals(endWord)) {
                            return level + 1;
                        }
    
                        if (!visited.contains(ajacentWord)) {
                            q.offer(new Pair<>(ajacentWord, level + 1));
                            visited.add(ajacentWord);
                        }
                    }
                }
            }
    
            return 0;
        }
    
        private String changeChatAt(String s, int index, char c) {
            char[] chars = s.toCharArray();
            chars[index] = c;
            return new String(chars);
        }
    }
    
}