/**
 * 665. 非递减数列
 * 数学
 * @author LBW
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i+1]) {
                cnt += 1;
                if (cnt > 1) {
                    return false;
                }
                // 此时要么减小nums[i]到nums[i+1]，要么增加nums[i+1]到nums[i].
                if (i > 0 && nums[i-1] > nums[i+1]) {  // 此时，说明减小nums[i]到nums[i+1]后，会导致前面的不符合，所以不能减小nums[i]，只能增加nums[i+1].
                    nums[i+1] = nums[i];
                }
                else {
                    nums[i] = nums[i+1];
                }
            }
        }
        return true;
    }
}
