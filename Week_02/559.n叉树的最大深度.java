import java.util.Objects;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Stack<Pair<Node, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int dep = 0;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> cur = stack.pop();
            Node node = cur.getKey();
            Integer curDep = cur.getVal();
            if (node.children.stream().allMatch(Objects::isNull)) {
                dep = Math.max(dep, curDep);
            } else {
                // filter non null children
                node.children.stream()
                    .filter(Objects::nonNull)
                    .forEach(child -> stack.push(new Pair<>(child, curDep+1)));
            }
        }
        return dep;
    }
}

class Pair<K, V> {
    K key;
    V val;
    public Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }
    public K getKey() {return this.key;}
    public V getVal() {return this.val;}
}
// @lc code=end

