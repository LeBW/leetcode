package interview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LBW
 * 草，这是 LeetCode 原题  976。 做过的，有点忘了。
 * 一开始只能想到暴力解法，时间复杂度 O（n^3)。真 tm 的惨，被怼了。
 *
 * 其实在排序之后，从大到小遍历元素，一层遍历就够了：
 *  对于每个元素，只需要判断它后面两个元素能不能和它组成三角形就可以了，因为这个如果不能组成的话，后面更小的元素就更不能组成了。
 */
public class HuaweiSecond {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 2, 3};
        HuaweiSecond huaweiSecond = new HuaweiSecond();
        System.out.println(huaweiSecond.maxTri(arr));
    }

    private int maxTri(int[] arr) {
        int res = 0;
        Integer[] arrs = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrs[i] = arr[i];
        }
        Arrays.sort(arrs, (i1, i2) -> (i2 - i1));
        for (int i = 0; i < arrs.length - 2; i++) {
            if (arrs[i + 1] + arrs[i + 2] > arrs[i]) {
                res = Math.max(res, arrs[i] + arrs[i + 1] + arrs[i + 2]);
            }
        }
        return res;
    }

}
