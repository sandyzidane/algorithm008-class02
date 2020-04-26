/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1
            && isBalanced(root.left)
            && isBalanced(root.right);
    }
    private int height(TreeNode tree) {
        if (tree == null) return 0;
        if (tree.left == null && tree.right == null) return 1;
        return Math.max(height(tree.left), height(tree.right)) + 1;
    }
}
// @lc code=end

