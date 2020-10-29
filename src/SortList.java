/**
 * 148. Sort List
 * 链表排序
 * @author LBW
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find the mid
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // cut the mid.
        ListNode tmp = slow.next;
        slow.next = null;
        // sort two lists
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // merge
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            }
            else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }
        if (left != null) {
            cur.next = left;
        }
        else if (right != null) {
            cur.next = right;
        }
        return dummy.next;
    }
}
