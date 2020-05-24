import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * 5418. Pseudo-Palindromic Paths in a Binary Tree
 * 判断是否回文序列的条件：最多只有一种元素出现的次数为奇数。
 * @author LBW
 */
public class PseudoPalindromicPath {
    private int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        ArrayList<Integer> path = new ArrayList<>();
        result = 0;
        dfs(root, path);

        return result;
    }
    private void dfs(TreeNode root, ArrayList<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null) {  //到叶节点了，path已经构建完毕，可以判断是否为回文序列了。
            if (isPseudoPalindrome(path))
                result += 1;
        }
        if (root.left != null)
            dfs(root.left, new ArrayList<>(path));
        if (root.right != null)
            dfs(root.right, new ArrayList<>(path));
    }

    private boolean isPseudoPalindrome(ArrayList<Integer> path) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        for (Integer i: path) {
            if (!hashtable.containsKey(i)) {
                hashtable.put(i, 1);
            }
            else {
                hashtable.put(i, hashtable.get(i)+1);
            }
        }
        int oddCount = 0;
        for (Map.Entry<Integer, Integer> entry: hashtable.entrySet()) {
            if (entry.getValue() % 2 == 1)
                oddCount += 1;
            if (oddCount > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        PseudoPalindromicPath pseudoPalindromicPath =  new PseudoPalindromicPath();
        int result = pseudoPalindromicPath.pseudoPalindromicPaths(root);
        System.out.println(result);
    }
}
