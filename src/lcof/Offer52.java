package lcof;

/**
 * Offer 52. 两个链表的第一个公共节点
 * 双指针。
 * 注意：循环判断条件可以用 pa != pb，会有两种情况：
 * 1. 有公共结点时，会在相遇点结束循环。
 * 2. 没有公共节点时，会在链表结尾处结束循环（两个都是 null）。
 * @author LBW
 */
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
