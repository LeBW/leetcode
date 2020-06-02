/**
 * 1038. Binary Search Tree to Greater Sum Tree
 * 中序遍历！
 * @author LBW
 */
public class BinarySearchTreeGS {
    private TreeNode prev = new TreeNode(0);

    public TreeNode bstToGst(TreeNode root) {
        if (root == null)
            return null;
        bstToGst(root.right);
        root.val += prev.val;
        prev = root;
        bstToGst(root.left);
        return root;
    }
}
