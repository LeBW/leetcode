package lcof;

/**
 * Offer 56. 数组中数字出现的次数
 * 异或。很巧妙。
 * 除了两个数字外，其他数字都出现一次，是 （除了一个数字外，其他数字都出现一次）的进阶版。
 * 核心思想是把数组分为两部分（两部分各含一个目标数字），然后分别做异或就可以了。
 * 那么如何分成符合要求的两部分呢？这里先对整个数组进行异或，得到值 z。
 * z 其实就是 目标值 x ^ y 的结果。所以 z 中为 1 的位，必定是 x 和 y 不同的位。
 * 我们随便找个 z 中为 1 的位，以此为基准对数组进行分组，就可以得到结果了。
 * @author LBW
 */
public class Offer56 {
    public int[] singleNumbers(int[] nums) {
        int n = nums.length;
        int z = 0;  // z 为 nums 中所有数字异或的结果，也就是 x & y 的结果
        for (int num: nums) {
            z ^= num;
        }
        int digit = 1;  // digit 指向 z 中为 1 的位（说明这一位在 x 和 y 中是不一样的值，可以以它为基准对 nums 进行分组
        while ((digit & z) == 0) {
            digit <<= 1;
        }
        int[] res = new int[2];
        for (int num: nums) {
            if ((num & digit) == 0) {
                res[0] ^= num;
            }
            else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
