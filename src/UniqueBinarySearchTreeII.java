import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * 递归。这题是95题的难化版本。
 * 95题使用了动态规划，因为求的是树的数目，因此子问题是重复的。（比如求123和234的BST数目，他们是相等的）
 * 这里则没有使用动态规划。但是其实也是有规律可循的（123和234产生的子树，结构相同，只是每个节点需要加一个偏差1）。
 * 因此动态规划理论上也是可以做的，留作以后尝试吧。
 * @author LBW
 */
public class UniqueBinarySearchTreeII {
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);  // start > end 时，也要产生一个null的子树
            return trees;
        }
        if (start == end) {   // start == end 时，刚好一个根结点
            trees.add(new TreeNode(start));
            return trees;
        }
        for (int i = start; i <= end; i++) {   //其他情况，开始递归
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode leftTree: leftTrees) {
                for (TreeNode rightTree: rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
