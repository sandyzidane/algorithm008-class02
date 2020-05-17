import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针II {

    class Solution {
        public Node connect(Node root) {
            // 层序遍历
            if (root == null)
                return root;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    Node cur = queue.poll();

                    if (i != levelSize - 1) {
                        cur.next = queue.peek();
                    }

                    if (cur.left != null)
                        queue.offer(cur.left);
                    if (cur.right != null)
                        queue.offer(cur.right);
                }
            }
            return root;

        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}