/**
 * 108. Convert Sorted Array to Binary Search Tree
 * 递归构造BST
 * @author LBW
 */
public class ConvertedSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end)
            return null;
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid-1);
        root.right = buildBST(nums, mid+1, end);
        return root;
    }
}
