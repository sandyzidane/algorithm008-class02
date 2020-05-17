import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {

    class Solution {
        int[] preorder;
        int[] inorder;
        int preIdx;
        Map<Integer, Integer> idxMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.inorder = inorder;
            this.preorder = preorder;
            preIdx = 0;

            int idx = 0;
            for (Integer val : inorder) {
                idxMap.put(val, idx++);
            }
            return helper(0, inorder.length);

        }

        public TreeNode helper(int inLeft, int inRight) {
            if (inLeft == inRight)
                return null;

            int rootVal = preorder[preIdx];
            TreeNode root = new TreeNode(rootVal);

            // root 把 inorder 分成左右子树
            int index = idxMap.get(rootVal);
            preIdx++;

            root.left = helper(inLeft, index);
            root.right = helper(index + 1, inRight);

            return root;
        }
    }

}