package lcof;

import java.util.Arrays;

/**
 * Offer45. 把数组排成最小的数
 * 特殊排序：字符串相加比较，x + y 比 y + x.
 * 注意，这里的难点是要证明这种比较具有传递性，然后就可以进行排序了。
 * @author LBW
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (str1, str2) -> (
                (str1 + str2).compareTo(str2 + str1)
        ));
        StringBuilder builder = new StringBuilder();
        for (String str: strs) {
            builder.append(str);
        }
        return builder.toString();
    }
}
