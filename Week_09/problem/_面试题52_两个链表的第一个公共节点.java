package problem;

/**
 * _面试题52_两个链表的第一个公共节点
 */
public class _面试题52_两个链表的第一个公共节点 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode node1 = headA, node2 = headB;

            while (node1 != node2) {
                node1 = node1 == null ? headB : node1.next;
                node2 = node2 == null ? headA : node2.next;
            }

            return node1;
        }
    }
}