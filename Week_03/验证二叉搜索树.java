/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class 验证二叉搜索树 {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        public boolean helper(TreeNode node, Integer low, Integer high) {
            if (node == null)
                return true;
            int val = node.val;
            if (low != null && val <= low)
                return false;
            if (high != null && val >= high)
                return false;
            if (!helper(node.right, val, high))
                return false;
            if (!helper(node.left, low, val))
                return false;
            return true;
        }
    }
}