package lcof;

/**
 * Offer18. 删除链表的节点
 * @author LBW
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null, cur = head;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) { // 说明找不到
            return head;
        }
        if (pre == null) { // 说明要去掉head
            return cur.next;
        }
        pre.next = cur.next;
        return head;
    }
}
