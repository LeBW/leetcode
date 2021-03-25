/**
 * 82. Remove Duplicates From Sorted List II
 * 链表操作。注意利用虚头节点，避免分类讨论
 * @author LBW
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, next = cur.next;
        while (cur != null) {
            next = cur.next;
            while (next != null && cur.val != next.val) {
                pre = cur;
                cur = next;
                next = cur.next;
            }
            if (next != null) { // 说明出现了重复
                while (next != null && cur.val == next.val) {
                    cur = next;
                    next = cur.next;
                }
                pre.next = next;
            }
            // start another detection
            cur = next;
        }
        return dummy.next;
    }
}
