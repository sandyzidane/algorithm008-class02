import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {

        // iterative version
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }
        int depth = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int currentDepth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, currentDepth);
                stack.add(new Pair<>(root.left, currentDepth + 1));
                stack.add(new Pair<>(root.right, currentDepth + 1));
            }
        }

        return depth;


        // recursion version
        // if (root == null) {
        //     return 0;
        // }
        // if (root.left == null && root.right == null) {
        //     return 1;
        // }
        // return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {return this.key;}
    public V getValue() {return this.value;}
}
// @lc code=end

