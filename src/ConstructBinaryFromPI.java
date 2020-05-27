import java.util.HashMap;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * @author LBW
 */
public class ConstructBinaryFromPI {
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if(len == 0)
            return null;
        for (int i = 0; i < len; i++)
            indexMap.put(inorder[i], i);

        return buildTree(preorder, 0, len-1, inorder, 0, len-1);
    }

    private TreeNode buildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR)
            return null;

        int r = preorder[preL];
        int i = indexMap.get(r);
        TreeNode root = new TreeNode(r);
        root.left = buildTree(preorder, preL + 1, preL + i - inL, inorder, inL, i - 1);
        root.right = buildTree(preorder, preL + i - inL + 1, preR, inorder, i + 1, inR);
        return root;
    }
}
