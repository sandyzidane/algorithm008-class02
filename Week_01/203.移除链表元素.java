/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode dummy = new ListNode(-1 * val);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur != null) {
            if (cur.next != null && cur.next.val == val) {
                // cut link
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
// @lc code=end

