import java.util.ArrayList;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * 递归思想.
 * 这个递归还挺难想到的！
 * @author LBW
 */
public class LowestCommonAncestor {
    // 这是一个比较简洁且效率高的写法.
    public TreeNode lowestCommonAncestorTwo(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {  //说明p和q都在右子树中
            return right;
        }
        if (right == null) { //说明p和q都在左子树中
            return left;
        }
        return root;
    }

    //这是我一开始的做法，分别找到从根结点到p和q的路径，记做pPath和qPath，然后从两条路径中寻找最后一个相同节点，即为最近公共祖先。
    ArrayList<TreeNode> pPath;
    ArrayList<TreeNode> qPath;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path = new ArrayList<>();
        dfs(root, path, p, q);
        int i = 0;
        while (i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i)) {
            i++;
        }
        return pPath.get(i-1);
    }

    private void dfs(TreeNode root, ArrayList<TreeNode> path, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root.val == p.val) {
            pPath = (ArrayList<TreeNode>) path.clone();
        }
        if (root.val == q.val) {
            qPath = (ArrayList<TreeNode>) path.clone();
        }
        dfs(root.left, path, p, q);
        dfs(root.right, path, p, q);
        path.remove(root);

    }
}
