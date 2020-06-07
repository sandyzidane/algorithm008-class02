import java.util.*;

public class _二叉树的锯齿形层次遍历 {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<TreeNode> q = new LinkedList<>();
            if (root != null) q.offer(root);
            while (!q.isEmpty()) {
                Deque<Integer> tmp = new LinkedList<>();
                for (int i = q.size(); i > 0; i--) {
                    TreeNode node = q.poll();
                    // 这里结果对象res的size刚好能反应当前进行到第几层了, 0代表根，即第一层
                    if (res.size() % 2 == 0) {
                        // 奇数层，从左往右，往队列尾部添加
                        tmp.addLast(node.val);
                    } else {
                        // 偶数层，从右往左，往队列头部添加
                        tmp.addFirst(node.val);
                    }
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
                res.add(new ArrayList<>(tmp));
            }
            return res;
        }
    }
    
}