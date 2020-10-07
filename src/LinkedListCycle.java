import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 * @author LBW
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!set.add(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 快慢指针。
     * 如果没环，快指针最终会走到终点；
     * 如果有环，快指针最后会追上慢指针。
     */
    public boolean hasCycleTwo(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next, slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
