package lcof;

/**
 * Offer 07. 重建二叉树
 * 递归。 注意 ps，pe，is，ie 四个指针的计算
 * @author LBW
 */
public class Offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        int root = preorder[ps];
        int mid = is;
        while (inorder[mid] != root) {
            mid += 1;
        }
        int leftlen = mid - is; // 左子树的长度
        TreeNode r = new TreeNode(root);
        r.left = buildTree(preorder, ps + 1, ps + leftlen, inorder, is, mid - 1);
        r.right = buildTree(preorder, ps + leftlen + 1, pe, inorder, mid + 1, ie);
        return r;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        Offer07 offer07 = new Offer07();
        offer07.buildTree(preorder, inorder);
    }
}
