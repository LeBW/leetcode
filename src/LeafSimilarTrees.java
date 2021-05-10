import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 * DFS
 * @author LBW
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = getleaf(root1);
        List<Integer> leaf2 = getleaf(root2);
        if (leaf1.size() != leaf2.size())
            return false;
        int n = leaf1.size();
        for (int i = 0; i < n; i++) {
            if (!leaf1.get(i).equals(leaf2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getleaf(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        if (node.left != null) {
            dfs(node.left, list);
        }
        if (node.right != null) {
            dfs(node.right, list);
        }
    }
}
