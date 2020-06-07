import java.util.*;

public class _在每个树行中找最大值 {

    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if (root != null)
                q.offer(root);

            while (!q.isEmpty()) {
                int levelMax = Integer.MIN_VALUE;
                int levelSize = q.size();
                while (levelSize-- > 0) {
                    TreeNode node = q.poll();
                    levelMax = Math.max(levelMax, node.val);
                    if (node.left != null)
                        q.offer(node.left);
                    if (node.right != null)
                        q.offer(node.right);
                }
                res.add(levelMax);
            }

            return res;

        }
    }

}