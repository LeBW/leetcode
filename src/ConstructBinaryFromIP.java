import java.util.HashMap;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * @author LBW
 */
public class ConstructBinaryFromIP {
    HashMap<Integer, Integer> indexMap = new HashMap<>();   //用map来存放中序遍历序列中的index，用以减少寻找索引的时间
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0)
            return null;
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, len-1, postorder, 0, len-1);
    }

    private TreeNode buildTree(int[] inorder, int inL, int inR, int[] postorder, int pL, int pR) {
        if (inL > inR)
            return null;
        int r = postorder[pR];
        int i = indexMap.get(r);
        TreeNode root = new TreeNode(r);
        // 下面的索引计算非常重要，有时候会搞混淆
        root.left = buildTree(inorder, inL, i - 1, postorder, pL, pL + i - inL - 1);
        root.right = buildTree(inorder, i + 1, inR, postorder, pL + i - inL, pR - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        ConstructBinaryFromIP constructBinaryFromIP = new ConstructBinaryFromIP();
        System.out.println(constructBinaryFromIP.buildTree(inorder, postorder));
    }
}
