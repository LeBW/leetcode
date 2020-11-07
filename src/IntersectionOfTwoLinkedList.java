import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked List
 * @author LBW
 */
public class IntersectionOfTwoLinkedList {
    /**
     * 方法一，哈希。时间复杂度O(n), 空间复杂度O(n).
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null && !set.contains(cur)) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode getIntersectionNodeTwo(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != null && pb != null) {
            pa = pa.next;
            pb = pb.next;
        }
        if (pa == null && pb == null) {  // 说明两个链表一样长
            pa = headA;
            pb = headB;
            while (pa != pb) {
                pa = pa.next;
                pb = pb.next;
            }
            return pa;
        }
        if (pa == null) { // 说明pa比较短，先让pa指向链表B，然后继续遍历，直到pb指向链表A
            pa = headB;
            while (pb != null) {
                pa = pa.next;
                pb = pb.next;
            }
            pb = headA;
        }
        else { // 说明pb比较短
            pb = headA;
            while (pa != null) {
                pa = pa.next;
                pb = pb.next;
            }
            pa = headB;
        }
        // 此时两个链表的起始差值已经消去，同时遍历直到相交即可。
        while (pa != null && pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }
}
