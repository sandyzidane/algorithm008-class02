import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class 从尾到头打印链表 {
    class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            int size = 0;
            while (head != null) {
                stack.push(head.val);
                head = head.next;
                size++;
            }

            int[] r = new int[size];
            int i = 0;
            while (!stack.isEmpty()) {
                r[i] = stack.pop();
                i++;
            }
            return r;
        }
    }
}