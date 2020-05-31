public class _236_二叉树的最近公共祖先 {

    class Solution {
        
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root.val == p.val || root.val == q.val) return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else if (left != null && right != null) {
                return root;
            }

            return null;
        }

        // public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        //     ;
        // }
    }
    
}