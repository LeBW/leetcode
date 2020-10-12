import java.util.HashSet;
import java.util.Set;

/**
 * 142. Linked List Cycle II
 * @author LBW
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!set.add(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
