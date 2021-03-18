/**
 * 92. Reversed LinkedList II
 * 链表翻转
 * @author LBW
 */
public class ReversedLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 使用虚拟头节点避免分类讨论
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 找到 left 前的节点和 right 后的节点
        ListNode leftNode = dummy;
        for (int i = 0; i < left - 1; i++) {
            leftNode = leftNode.next;
        }
        ListNode cur = leftNode;
        for (int i = 0; i < right - left + 1; i++) {
            cur = cur.next;
        }
        // 切断，进行翻转
        ListNode rightNode = cur.next;
        cur.next = null;
        ListNode reverseHead = reverse(leftNode.next);
        // 连接
        leftNode.next.next = rightNode;
        leftNode.next = reverseHead;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, next = head.next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
