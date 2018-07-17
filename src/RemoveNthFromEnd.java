/**
 * <a href=https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/>
 * Click here to see online description.
 * </a>
 *<br>
 * Traverse the List in one pass.
 * @author LBW
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode leader = head, cur = head;
        for (int i = 0; i < n; i++)
            leader = leader.next;
        //if remove the first
        if (leader == null) {
            return head.next;
        }
        //go ahead, make cur.next be the node that is going to be deleted.
        while (leader.next != null) {
            leader = leader.next;
            cur = cur.next;
        }
        //delete cur.next
        cur.next = cur.next.next;
        return head;
    }
}
