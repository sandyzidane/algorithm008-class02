/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 一个一个加上去
        boolean plusOne = false;
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode result = new ListNode(0);
        ListNode res = result;
        
        while (n1 != null || n2 != null || plusOne) {
            int val1 = n1 != null ? n1.val : 0;
            int val2 = n2 != null ? n2.val : 0;
            
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
            
            int sum = val1 + val2;
            if (plusOne) {
                sum++;
            }
            
            plusOne = sum >= 10;
            res.val = sum % 10;
            
            if (plusOne || n1 != null || n2 != null) {
                res.next = new ListNode(0);
                res = res.next;
            }
        }
        return result;
    }
}
// @lc code=end

