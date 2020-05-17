import java.util.HashSet;
import java.util.Set;

public class 环形链表II {

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // set存储访问过的节点
            Set<ListNode> set = new HashSet<>();
            ListNode cur = head;
            while (cur != null) {
                if (set.contains(cur)) {
                    return cur;
                }
                set.add(cur);
                cur = cur.next;
            }
            return null;
        }
    }

}