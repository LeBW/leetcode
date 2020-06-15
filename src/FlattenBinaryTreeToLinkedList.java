/**
 * 114. Flatten Binary Tree to Linked List
 * @author LBW
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            if (cur.left == null) {  // cur.left为空时，直接处理下一个
                cur = cur.right;
                continue;
            }
            // left为「左子树中的最右节点」
            TreeNode left = cur.left;
            while (left.right != null) {
                left = left.right;
            }
            // 将当前节点cur的右子树插入左子树的最右边节点上
            left.right = cur.right;
            // 将整个左子树变成右子树
            cur.right = cur.left;
            // 并将左子树置为null
            cur.left = null;
            // 循环处理 cur.right
            cur = cur.right;
        }
    }
}
