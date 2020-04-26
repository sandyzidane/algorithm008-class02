/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        int minDep = Integer.MAX_VALUE;
        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            TreeNode node = cur.getKey();
            int curDep = cur.getVal();
            if (node.left == null && node.right == null) {
                minDep = Math.min(minDep, curDep);
            }
            if (node.left != null) stack.push(new Pair<>(node.left, curDep + 1));
            if (node.right != null) stack.push(new Pair<>(node.right, curDep + 1));
        }

        return minDep;
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

