package lcof;

/**
 * Offer33. 二叉搜索树的后序遍历序列
 * 对于 postorder，判断整棵树是不是平衡二叉树，首先明白 最后一个数即为根节点。
 * * 根据根节点的值，找出左子树（左子树所有的值都比根节点小）
 * * 然后判断右子树是不是都比根节点大（否则可以直接返回false）
 * * 然后递归判断左右子树是否满足即可
 * @author LBW
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        return verifyPostorder(postorder, 0, n - 1);
    }

    private boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int mid = start;
        while (postorder[mid] < postorder[end]) {
            mid += 1;
        }
        for (int i = mid; i < end; i++) {
            if (postorder[i] < postorder[end]) {
                return false;
            }
        }
        return verifyPostorder(postorder, start, mid - 1) && verifyPostorder(postorder, mid, end - 1);
    }
}
