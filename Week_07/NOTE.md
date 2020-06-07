# Week07学习笔记

## 知识要点
- Trie树、并查集
- 双向BFS
- A\*搜索
- 红黑树、AVL树

## 练习
- 分析单词搜索 2 用 Tire 树方式实现的时间复杂度
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
