import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 使用堆？？？
        // 小根堆/大根堆？

        //if (lists.length == 0) return null;
        // 使用小根堆，先全部推进去，再一个个取出来
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode ln : lists) {
            while (ln != null) {
                pq.offer(ln.val);
                ln = ln.next;
            }
        }

        if (pq.isEmpty()) return null;
        ListNode head = new ListNode(pq.poll());
        ListNode r = head;
        while (!pq.isEmpty()) {
            head.next = new ListNode(pq.poll());
            head = head.next;
        }
        return r;
    }
}
// @lc code=end

