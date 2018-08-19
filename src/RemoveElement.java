/**
 * <a href=https://leetcode-cn.com/problems/remove-element/description/>
 * Click to see online description
 * </a>
 * <br>
 * @author LBW
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for (;j < nums.length; j++) {
            if (nums[j] != val)
                nums[i++] = nums[j];
        }
        return i;
    }
}
