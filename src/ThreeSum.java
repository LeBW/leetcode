import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LBW
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //skip repeated.
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int num1 = nums[i];
            int left = i + 1, right = len - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -num1) {
                    result.add(Arrays.asList(num1, nums[left], nums[right]));
                    left++;
                    right--;
                    //skip repeated
                    while (left < right && nums[left] == nums[left-1])
                        left++;
                    while (left < right && nums[right] ==nums[right+1])
                        right--;
                }
                else if (nums[left] + nums[right] < -num1) {
                    left++;
                    //skip repeated
                    while (left < right && nums[left] == nums[left-1])
                        left++;
                }
                else {
                    right--;
                    //skip repeated
                    while (left < right && nums[right] ==nums[right+1])
                        right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }
}
