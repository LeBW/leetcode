package lcof;

/**
 * Offer 36. 二叉搜索树与双向链表
 * 二叉搜索树的中序遍历 & 链表
 * @author LBW
 */
public class Offer36 {
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        dfs(root);
        // 头尾之间相连
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) { // 说明在访问链表的头节点
            head = cur;
            pre = cur;
        }
        else {  // 将 pre 和 cur 之间做双向链表关联
            pre.right = cur;
            cur.left = pre;
            // update pre
            pre = cur;
        }
        dfs(cur.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
