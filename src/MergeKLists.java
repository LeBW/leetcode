import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href=https://leetcode-cn.com/problems/merge-k-sorted-lists/description/>
 * Click to see online description
 * </a>
 * <br>
 * In my solution, I use the PriorityQueue(min heap) to solve the problem.
 *
 * 23. Merge k Sorted Lists
 * 最小堆（优先级队列）
 * @author LBW
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        //init the queue
        for (ListNode list: lists) {
            if(list != null)
                queue.offer(list);
        }

        //start to get result.
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            cur.next = new ListNode(minNode.val);
            cur = cur.next;
            //get the next node.
            if (minNode.next != null)
                queue.offer(minNode.next);
        }
        return dummy.next;
    }
}
