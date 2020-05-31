import java.util.*;

public class _105_从前序与中序遍历序列构造二叉树 {
    class Solution {
        int[] preorder;
        int[] inorder;
        int preIdx;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;

            preIdx = 0;

            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return buildTreeFromInorder(0, inorder.length);
        }

        public TreeNode buildTreeFromInorder(int left, int right) {
            if (left == right)
                return null;

            int rootVal = preorder[preIdx];
            TreeNode root = new TreeNode(rootVal);

            int rootIdx = map.get(rootVal);
            preIdx++;

            root.left = buildTreeFromInorder(left, rootIdx);
            root.right = buildTreeFromInorder(rootIdx + 1, right);

            return root;
        }
    }
}