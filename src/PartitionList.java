/**
 * 86. Partition List
 * 链表
 * @author LBW
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallhead = new ListNode(-1);
        ListNode small = smallhead;
        ListNode largehead = new ListNode(-1);
        ListNode large = largehead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = new ListNode(cur.val);
                small = small.next;
            }
            else {
                large.next = new ListNode(cur.val);
                large = large.next;
            }
            cur = cur.next;
        }
        small.next = largehead.next;
        return smallhead.next;
    }
}
