/**
 * 83. Remove Duplicates From Sorted List
 * 链表
 * @author LBW
 */
public class RemoveDuplicatesFromSL {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
