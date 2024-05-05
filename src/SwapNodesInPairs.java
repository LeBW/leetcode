/**
 * 24. Swap Nodes in Pairs
 * 使用方法二，递归，较为简单
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
        ListNode third = second.next;

        second.next = first;

        while (third != null && third.next != null) {
            first.next = third.next;
            first = third;
            second = third.next;
            third = second.next;

            second.next = first;

        }
        first.next = third;

        return result;
    }

    /**
     * 方法二，递归
     */
    public ListNode swapPairsTwo(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode next = cur.next;
        cur.next = head;
        head.next = swapPairsTwo(next);
        return cur;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        swapNodesInPairs.swapPairsTwo(head);
    }
}
