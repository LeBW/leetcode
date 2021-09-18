/**
 * 21. Merge Two Sorted Lists
 * <a href=https://leetcode-cn.com/problems/merge-two-sorted-lists/description/>
 * Click here to see online description.
 * </a>
 *<br>
 *
 * @author LBW
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        else if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}
