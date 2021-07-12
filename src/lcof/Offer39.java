package lcof;

/**
 * Offer39. 数组中出现次数超过一半的数字
 * 摩尔投票法
 * @author LBW
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count += 1;
            }
            else if (count > 0){
                count -= 1;
            }
            else {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }
}
