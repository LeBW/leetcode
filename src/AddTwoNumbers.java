/**
 * Use Elementary Math to solve the problem. attention:
 *
 * <p>1. Use dummy head when using LinkNode. It's convenience because you don't need to judge whether it's head.
 * <p>2. Simplify your code.
 * <p>3. judge whether carry is 1 when it ends.
 *
 * @author LBW
 */
public class AddTwoNumbers {
    /**
     * this is my initial version
     */
    @SuppressWarnings("Duplicates")
    @Deprecated
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, current = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            int sum = val1 + val2 + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;

            if (head == null) {
                head = new ListNode(sum % 10);
                current = head;
            }
            else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;

            current.next = new ListNode(sum % 10);
            current = current.next;
            l2 = l2.next;
        }
        // if still has carry. like 5+5=10
        if (carry == 1)
            current.next = new ListNode(1);
        return head;
    }

    /**
     * this is referenced by standard solution.
     */
    public ListNode standardAddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int p = l1 != null ? l1.val : 0;
            int q = l2 != null ? l2.val : 0;
            int sum = p + q + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1)
            current.next = new ListNode(1);
        return dummyHead.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(null, null);
        addTwoNumbers.standardAddTwoNumbers(null, null);
    }

}
