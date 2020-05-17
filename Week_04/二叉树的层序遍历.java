import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class 二叉树的层序遍历 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            // 使用修改后的BFS
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelEle = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    levelEle.add(cur.val);
                    if (cur.left != null)
                        queue.add(cur.left);
                    if (cur.right != null)
                        queue.add(cur.right);
                }
                result.add(levelEle);
            }
            return result;
        }
    }
}