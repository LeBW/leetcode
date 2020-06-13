import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * @author LBW
 */
public class PathSumII {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> l = new ArrayList<>();
        findPathSum(root, l, 0, sum);
        return result;
    }

    private void findPathSum(TreeNode root, List<Integer> l, int cur, int sum) {
        if (root == null)
            return;
        l.add(root.val);
        int t = cur + root.val;
        if (root.left == null && root.right == null) {
            if (t == sum) {
                List<Integer> newl = new ArrayList<>(l);
                result.add(newl);
            }
        }
        findPathSum(root.left, l, t, sum);
        findPathSum(root.right, l, t, sum);
        l.remove(l.size() - 1);
        cur -= root.val;  //这句没啥用吧
    }

    public static void main(String[] args) {
        PathSumII pathSumII = new PathSumII();
        pathSumII.pathSum(null, 0);
    }
}
