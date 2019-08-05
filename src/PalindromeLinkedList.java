/**
 * @author LBW
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // reverse the second half.
        ListNode tail = reverseList(slow);
        ListNode left = head, right = tail;
        boolean result = true;
        while (right != null) {
            if (left.val != right.val) {
                result = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        // recover the list
        reverseList(tail);
        return result;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(head));
        System.out.println(palindromeLinkedList.reverseList(head));
    }
}
