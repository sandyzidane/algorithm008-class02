public class 二叉树的最大深度 {

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return depth(root, 0);
        }

        public int depth(TreeNode root, int cur) {
            if (root == null)
                return cur;
            int leftDep = depth(root.left, cur + 1);
            int rightDep = depth(root.right, cur + 1);
            return Math.max(leftDep, rightDep);
        }
    }

}