# Week07学习笔记

## 知识要点
- Trie树、并查集
- 双向BFS
- A\*搜索
- 红黑树、AVL树

## 练习
- 分析单词搜索 2 用 Tire 树方式实现的时间复杂度
    - 前缀树解法代码
    ```java
        class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;

        public TrieNode() {
        }
    }

    class Solution {
        char[][] _board = null;
        ArrayList<String> _result = new ArrayList<String>();

        public List<String> findWords(char[][] board, String[] words) {

            // Step 1). Construct the Trie
            // 构建Trie的时间复杂度，最坏情况：平均单词长度 k * 单词个数 m = O(km)
            TrieNode root = new TrieNode();
            for (String word : words) {
                TrieNode node = root;

                for (Character letter : word.toCharArray()) {
                    if (node.children.containsKey(letter)) {
                        node = node.children.get(letter);
                    } else {
                        TrieNode newNode = new TrieNode();
                        node.children.put(letter, newNode);
                        node = newNode;
                    }
                }
                node.word = word; // store words in Trie
            }

            this._board = board;
            // Step 2). Backtracking starting for each cell in the board
            for (int row = 0; row < board.length; ++row) {
                for (int col = 0; col < board[row].length; ++col) {
                    if (root.children.containsKey(board[row][col])) {
                        backtracking(row, col, root);
                    }
                }
            }

            return this._result;
        }

        private void backtracking(int row, int col, TrieNode parent) {
            Character letter = this._board[row][col];
            TrieNode currNode = parent.children.get(letter);

            // check if there is any match
            if (currNode.word != null) {
                this._result.add(currNode.word);
                currNode.word = null;
            }

            // mark the current letter before the EXPLORATION
            this._board[row][col] = '#';

            // explore neighbor cells in around-clock directions: up, right, down, left
            int[] rowOffset = { -1, 0, 1, 0 };
            int[] colOffset = { 0, 1, 0, -1 };
            for (int i = 0; i < 4; ++i) {
                int newRow = row + rowOffset[i];
                int newCol = col + colOffset[i];
                if (newRow < 0 || newRow >= this._board.length || newCol < 0 || newCol >= this._board[0].length) {
                    continue;
                }
                if (currNode.children.containsKey(this._board[newRow][newCol])) {
                    backtracking(newRow, newCol, currNode);
                }
            }

            // End of EXPLORATION, restore the original letter in the board.
            this._board[row][col] = letter;

            // Optimization: incrementally remove the leaf nodes
            if (currNode.children.isEmpty()) {
                parent.children.remove(letter);
            }
        }
    }
    ```
    - 时间复杂度分析
        - 构建前缀树的时间复杂度是O(k * m)，k是单词平均长度，m是单词个数
        - 后面回溯部分，是递归调用。往四个方向搜索的话，应该是分成4个子问题？这里能使用主定理来求吗？不确定
- 双向BFS模板
```java
    public String twoEndBFS(Object begin, Object end) {

        Queue<Object> startQ = new LinkedList<>();
        Queue<Object> endQ = new LinkedList<>();
        Set<Object> sVisited = new HashSet<>();
        Set<Object> eVisited = new HashSet<>();

        startQ.offer(begin);
        sVisited.add(begin);
        endQ.offer(end);
        eVisited.add(end);

        while (!startQ.isEmpty() && !endQ.isEmpty()) {
            // 从 begin 往 end 方向搜索
            if (!startQ.isEmpty()) {
                Object x = startQ.poll();
                if (x.equals(end) || eVisited.contains(x)) {
                    // 找到了
                    return "SUCCESS";
                }
                for (Object nextX : getNextPossible(x)) {
                    if (!sVisited.contains(nextX)) {
                        sVisited.add(nextX);
                        startQ.offer(nextX);
                    } else {
                        // 已经搜索过了，看情况要不要处理
                    }
                }
            }

            // 从 end 往 begin 方向搜索
            if (!endQ.isEmpty()) {
                Object y = endQ.poll();
                if (y.equals(begin) || sVisited.contains(y)) {
                    // 找到了
                    return "SUCCESS";
                }
                for (Object nextY : getNextPossible(y)) {
                    if (!eVisited.contains(nextY)) {
                        eVisited.add(nextY);
                        endQ.offer(nextY);
                    } else {
                        // 已经搜索过了
                    }
                }
            }
        }
        // 如果走到这里，说明没找到
        return "FAIL";
    }
```
