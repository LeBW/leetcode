import java.util.HashSet;
import java.util.Set;

/**
 * 136. Single Number
 * @author LBW
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> memo = new HashSet<>();
        for (int num: nums) {
            if (memo.contains(num)) {
                memo.remove(num);
            }
            else {
                memo.add(num);
            }
        }
        Integer[] res = new Integer[memo.size()];
        memo.toArray(res);
        return res[0];
    }

    /**
     * 异或。神奇的方法
     */
    public int singleNumberTwo(int[] nums) {
        int res = nums[0];
        for (int i = 1; i <nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
