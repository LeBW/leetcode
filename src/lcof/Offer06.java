package lcof;

/**
 * Offer 06. 从尾到头打印链表
 * @author LBW
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count += 1;
            cur = cur.next;
        }
        cur = head;
        int[] res = new int[count];
        int idx = count - 1;
        while (cur != null) {
            res[idx--] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}

