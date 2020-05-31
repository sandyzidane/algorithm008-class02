import java.util.*;

public class _429_N叉树的层序遍历 {
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {

            Queue<Node> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) {
                queue.offer(root);
            }

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> levelEle = new ArrayList<>();
                while (levelSize-- > 0) {
                    Node cur = queue.poll();
                    levelEle.add(cur.val);
                    cur.children.stream().filter(Objects::nonNull).forEach(queue::offer);
                }
                res.add(levelEle);
            }

            return res;
        }
    }
}