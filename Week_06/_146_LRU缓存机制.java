import java.util.*;

/**
 * _146_LRU缓存机制
 */
public class _146_LRU缓存机制 {

    class LRUCache {

        class Node {
            int key;
            int val;

            Node(int k, int v) {
                this.key = k;
                this.val = v;
            }

            public boolean equals(Node other) {
                if (other == null)
                    return false;
                return this.key == other.key;
            }
        }

        // 头节点放最近访问过的元素，尾节点放马上要被抛弃的节点
        LinkedList<Node> l;
        int cap;

        public LRUCache(int capacity) {
            l = new LinkedList<Node>();
            cap = capacity;
        }

        public int get(int key) {
            Node target = null;
            for (Node n : l) {
                if (n.key == key) {
                    target = n;
                }
            }
            if (target != null) {
                l.remove(target);
                l.addFirst(target);
                return target.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            int size = l.size();

            if (get(key) != -1) {
                for (Node n : l) {
                    if (n.key == key) {
                        n.val = value;
                    }
                }
                return;
            } else {
                if (size == cap) {
                    // 抛弃最后的节点
                    l.pollLast();
                }
                l.offerFirst(new Node(key, value));
            }
        }
    }
}