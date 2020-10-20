/**
 * 143. Reorder List
 * @author LBW
 * * 快慢指针找中点
 * * 反转列表
 * * 合并列表
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        // 用快慢指针来寻找中间指针
        ListNode mid = head, tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next.next;
            mid = mid.next;
        }
        ListNode h2 = mid.next;
        mid.next = null;
        // 反转后半部分链表
        h2 = reverse(h2);
        // 合并前半和后半链表
        merge(head, h2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    private void merge(ListNode h1, ListNode h2) {
        ListNode h1t = h1, h2t = h2;
        while (h1 != null && h2 != null) {
            h1t = h1.next;
            h2t = h2.next;

            h1.next = h2;
            h1 = h1t;
            h2.next = h1;
            h2 = h2t;
        }
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reorderList.reorderList(head);
        System.out.println(head);
    }
}
