/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class 二叉树的最近公共祖先 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // terminator
            if (root == null || root.val == p.val || root.val == q.val)
                return root;
            // process

            // drill down
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return root;
        }
    }
}