import java.util.*;

public class _二叉树的中序遍历 {

    /**
     * 循环版本
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
    
            if (root == null) {
                return res;
            }
    
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                if (cur != null) {
                    if (cur.right != null) stack.push(cur.right);
    
                    stack.push(cur);
                    // 多推一个特殊值
                    stack.push(null);
    
                    if (cur.left != null) stack.push(cur.left);
                } else {
                    // 碰到null值了，说明有之前访问过的节点第二次遇到了
                    res.add(stack.pop().val);
                }
            }
    
            return res;
        }
    }
    
}