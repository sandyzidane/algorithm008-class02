import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> r = new ArrayList<>();

            if (root != null) {
                if (root.left != null)
                    r.addAll(inorderTraversal(root.left));
                r.add(root.val);
                if (root.right != null)
                    r.addAll(inorderTraversal(root.right));
            }

            return r;
        }
    }

}