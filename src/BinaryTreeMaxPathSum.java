/**
 * 124. Binary Tree Maximum Path Sum
 * @author LBW
 */
public class BinaryTreeMaxPathSum {
    private int max = Integer.MIN_VALUE;   // 用来存储最大路径和

    public int maxPathSum(TreeNode root) {
        oneSideMax(root);  //此时不能直接返回，因为返回值是“一边”的最大和。我们是用全局变量max来存放真正的最大和的。
        return max;
    }

    /**
     * 递归，返回的是：当前root以及某一边（左或右）最大的路径和，因此取名为 oneSideMax。
     */
    private int oneSideMax(TreeNode root) {
        if (root == null)   //
            return 0;
        int left = Math.max(oneSideMax(root.left), 0);
        int right = Math.max(oneSideMax(root.right), 0);
        if (root.val + left + right > max)   // 这一句，是用来测试局部最大值的
            max = root.val + left + right;
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaxPathSum binaryTreeMaxPathSum = new BinaryTreeMaxPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(binaryTreeMaxPathSum.maxPathSum(root));
    }
}
