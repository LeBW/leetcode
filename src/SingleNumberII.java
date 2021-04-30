/**
 * 137. Single Number II
 * 按位计算.
 * 因为 (1+1+1) % 3 = 0, (0+0+0) % 3 = 0 . 所以对于每一位，全部相加然后 % 3，就是结果的相应位了。
 * @author LBW
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num: nums) {
                sum += (num >> i) & 1;
            }
            ans |= (sum % 3) << i;
        }
        return ans;
    }
}
