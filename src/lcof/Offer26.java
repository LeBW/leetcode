package lcof;

/**
 * Offer26. 树的子结构
 * @author LBW
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        // 对 A 进行遍历
        return traverse(A, B);
    }

    // 对 A 进行遍历，每个节点都判断 compare (A, B)，用来判断两个树是否是包含关系
    private boolean traverse(TreeNode A, TreeNode B) {
        if (A == null)
            return false;
        if (compare(A, B)) {
            return true;
        }
        return traverse(A.left, B) || traverse(A.right, B);
    }

    // 判断 B 是否包含在 A 树中
    private boolean compare(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        else if (A == null) {
            return false;
        }
        else if (A.val != B. val) {
            return false;
        }
        else {
            return compare(A.left, B.left) && compare(A.right, B.right);
        }
    }
}
