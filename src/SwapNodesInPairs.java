/**
 * <a href=https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/>
 * Click to see online description
 * </a>
 * <br>
 *
 * @author LBW
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode result = head.next;
        ListNode first = head, second = head.next;

        while (true) {
            ListNode third = second.next;

            second.next = first;
            if (third != null && third.next != null) {
                first.next = third.next;
                first = third;
                second = third.next;
            }
            else {
                first.next = third;
                break;
            }
        }
        return result;
    }
}
