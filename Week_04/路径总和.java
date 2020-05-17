public class 路径总和 {

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;
            return helper(root, 0, sum);
        }

        public boolean helper(TreeNode node, int cur, int sum) {
            if (node == null)
                return false;
            if (node.left == null && node.right == null && node.val + cur == sum)
                return true;

            return helper(node.left, cur + node.val, sum) || helper(node.right, cur + node.val, sum);
        }
    }

}