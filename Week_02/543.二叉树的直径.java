/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int l = depth(node.left), r = depth(node.right);
        ans = Math.max(ans, l+r+1);
        return Math.max(l, r) + 1;
    }
}
// @lc code=end

