import java.util.ArrayList;
import java.util.List;

/**
 * 1018. Binary Prefix Divisible by 5
 * 考虑到数组A可能很长，直接计算的话值可能会很大甚至溢出，因此每次计算的时候我们只考虑余数就好。
 * @author LBW
 */
public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int cur = 0;
        for (int i: A) {
            cur = (cur * 2 + i) % 5;  // 这里计算的时候直接取余，可以有效防止溢出
            if (cur == 0) {
                ans.add(true);
            }
            else {
                ans.add(false);
            }
        }
        return ans;
    }
}
