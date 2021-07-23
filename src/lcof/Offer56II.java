package lcof;

/**
 * Offer 56-II. 数组中数字出现的次数 II
 * 这里的方法比较通用一点：用 counts[32] 记录 nums 数组中每个数字的每一位出现的次数之和。
 * 然后对所有位 对 3 取余，结果就是 res 中相应位的值。
 * @author LBW
 */
public class Offer56II {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32]; // 记录各位出现的次数
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < 32; j++) {
                counts[j] += (num & 1);
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= counts[i] % 3;
        }
        return res;

    }
}
