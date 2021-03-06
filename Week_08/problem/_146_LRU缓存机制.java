package problem;

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
                if (other == null) return false;
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
    
    // get 能获取得到 -> 访问次数+1，或是移走
    // put 容量不够 -> 把一个顶端的元素移走
    // Deque 能实现吗？可能时间复杂度不行
    
    // [] -> [1] -> [1,2] -> [1,2,3] -> [2,1,3] -> [3,2,1]
    
    // 多个队列能实现么？
    // 链表能实现吗？
}