/**
 * 61. Rotate List
 * @author LBW
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len += 1;
        }
        if (len < 2)
            return head;
        k = k % len;
        while (k-- > 0) {
            head = rotateRight(head);
        }
        return head;
    }

    private ListNode rotateRight(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        cur.next = head;
        return cur;
    }
}
