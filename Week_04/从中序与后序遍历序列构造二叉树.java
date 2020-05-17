import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树 {

    class Solution {
        int[] inorder;
        int[] postorder;
        int postIndex;
        Map<Integer, Integer> idxMap = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;

            postIndex = postorder.length - 1;

            int idx = 0;
            for (Integer val : inorder) {
                idxMap.put(val, idx++);
            }
            return helper(0, inorder.length - 1);
        }

        public TreeNode helper(int inLeft, int inRight) {
            if (inLeft > inRight)
                return null;

            int rootVal = postorder[postIndex];
            TreeNode root = new TreeNode(rootVal);

            // root 把 inorder列表分成左右子树
            int index = idxMap.get(rootVal);

            postIndex--;
            root.right = helper(index + 1, inRight);
            root.left = helper(inLeft, index - 1);
            return root;
        }

    }

}