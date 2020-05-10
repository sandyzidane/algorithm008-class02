/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class 合并两个有序链表 {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(Integer.MIN_VALUE);
            ListNode r = result;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    result.next = l2;
                    l2 = l2.next;
                } else if (l2 == null) {
                    result.next = l1;
                    l1 = l1.next;
                } else {
                    if (l1.val < l2.val) {
                        result.next = l1;
                        l1 = l1.next;
                    } else {
                        result.next = l2;
                        l2 = l2.next;
                    }
                }
                result = result.next;
            }
            return r.next;
        }
    }
}