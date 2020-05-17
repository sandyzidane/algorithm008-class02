public class 对称二叉树 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return isMirror(root.left, root.right);
        }

        public boolean isMirror(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null)
                return true;
            if (node1 == null || node2 == null)
                return false;
            return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node2.left, node1.right);
        }
    }

}