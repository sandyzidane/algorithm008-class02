/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class 另一个树的子树 {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return dfs(s, t);
        }
    
        public boolean check(TreeNode o, TreeNode t) {
            if (o == null && t == null) return true;
            if ((o != null && t == null) || (o == null && t != null) || (o.val != t.val)) return false;
            return check(o.left, t.left) && check(o.right, t.right);
        }
    
        public boolean dfs(TreeNode o, TreeNode t) {
            if (o == null) return false;
            return check(o, t) || dfs(o.left, t) || dfs(o.right, t);
        }
    }
}