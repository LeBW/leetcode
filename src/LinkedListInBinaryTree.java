/**
 * 1367. Linked List in Binary Tree
 * @author LBW
 */
public class LinkedListInBinaryTree {
    /**
     * 对每一个树节点，都要执行dfs()函数. 只要某一个满足了，那就是true
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    /**
     * 从root节点开始，深度遍历寻找是否有路径与链表head相同
     */
    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null)  // 如果链表都已经走完了，说明该路径相同，返回true
            return true;
        if (root == null)  // 如果是树走完了（此时链表还没走完），那这条路径肯定是不行的
            return false;
        if (head.val == root.val) {  // 现在链表和树都没完，判断当前是不是相等，相等就往下遍历
            return dfs(head.next, root.left) || dfs(head.next, root.right);
        }
        else  // 不相等就是错的
            return false;
    }
}
