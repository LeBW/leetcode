import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * @author LBW
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > (n / 2)) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 摩尔投票法。原理：出现超过一半次数的元素，一定比其他所有元素加起来的个数都要多，因此candidate最终一定会指向出现超过一半次数的元素。
     */
    public int majorityElementTwo(int[] nums) {
        int n = nums.length;
        int candidate = nums[0], count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            if (nums[i] == candidate) {
                count += 1;
            }
            else {
                count -= 1;
            }
        }
        return candidate;
    }
}
