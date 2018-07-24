/**
 * <a href=https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/>
 * Click to see online description
 * </a>
 * <br>
 * 递归的思想 + 反转列表的写法，属于比较困难的一题.
 * @author LBW
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count += 1;
        }
        if (count == k) {
            //reverse the next k group by recursion
            cur = reverseKGroup(cur, k);

            //reverse (head, ..., cur)
            while (count > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
                count--;
            }
            head = cur;
        }
        return head;
    }
}
