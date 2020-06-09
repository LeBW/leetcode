/**
 * 98. Validate Binary Search Tree
 * @author LBW
 */
public class ValidateBinarySearchTree {
    private TreeNode prev = null;   // store last accessed element.
    private boolean result = true;  // store the final result.
    public boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);  // 中序遍历
        return result;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        // compare prev and cur(root)
        if (prev != null && root.val <= prev.val)
            result = false;
        // change prev
        prev = root;
        // continue to traverse
        inOrderTraversal(root.right);
    }
}
