package lcof;

/**
 * Offer22. 链表中倒数第k个节点
 * @author LBW
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode l = head, r = head;
        for (int i = 0; i < k; i++) {
            r = r.next;
        }
        while (r != null) {
            l = l.next;
            r = r.next;
        }
        return l;
    }
}
