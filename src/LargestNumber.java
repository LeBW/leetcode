import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number
 * 运用了一种比较巧妙的字符串排序方法：(s2 + s1).compareTo(s1 + s2).
 * 因为题意是要找出组合起来最大的数字（字符串），可能首先会想到，对于两个字符串 s1 和 s2：
 * 1. 当首字母不同时，比首字母即可。
 * 2. 当前面有字符相同时，比较后面的字符。
 * 3. 当两字符串长度不一样，前面的又相同时，需要比后面的。
 *
 * 上面的情况看起来很复杂，但是归根到底，两个字符串拼接，要么是 s1 + s2，要么是 s2 + s1，所以比较这两个结果的大小即可。
 * @author LBW
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numStrings = new String[n];  // 先把 nums 转化为 字符串数组
        for (int i = 0; i < n; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);  // 这里是一种十分巧妙的排序
            }
        });
        if (numStrings[0].equals("0"))  // 考虑全 0 的特殊情况
            return "0";
        String res = "";
        for (int i = 0; i < n; i++) {
            res += numStrings[i];
        }
        return res;
    }
}
