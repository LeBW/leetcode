package lcof;

/**
 * Offer 25. 合并两个排序的链表
 * @author LBW
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = new ListNode(cur1.val);
                cur1 = cur1.next;
            }
            else {
                cur.next = new ListNode(cur2.val);
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        else if (cur2 != null) {
            cur.next = cur2;
        }
        return dummy.next;
    }
}
