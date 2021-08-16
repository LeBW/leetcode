import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * 哈希。（如果要求空间复杂度 O（1），就要用原地哈希）
 * 即原数组 nums 顺便用来做哈希表的作用。因此我们要对它进行一个 小 trick，当作哈希表时，要将内数目+n
 * @author LBW
 */
public class FindAllNumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num: nums) {
            nums[(num - 1) % n] += n;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
