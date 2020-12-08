import java.util.ArrayList;
import java.util.List;

/**
 * 842. Split Array into Fibonacci Sequence
 * @author LBW
 */
public class SplitArrayIntoFibonacciSequence {
    // 回溯算法
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        backTrack(res, S, 0, 0);
        return res;
    }

    private boolean backTrack(List<Integer> res, String S, int idx, int sum) {
        if (idx >= S.length()) { // 结束回溯
            return res.size() > 2;
        }
        if (res.size() < 2) {
            // 不用考虑斐波拉契，直接遍历回溯即可
            int endIdx = idx + 1;
            while (endIdx <= S.length()) {
                String subs = S.substring(idx, endIdx);
                if (S.charAt(idx) == '0' && endIdx > idx + 1)  // 去掉 leading-zero 的情况。
                    break;
                long subi = Long.parseLong(subs);
                if (subi > Integer.MAX_VALUE) // 如果取值比int大，就该退出了
                    break;
                res.add((int) subi);
                if (backTrack(res, S, endIdx, sum + (int) subi)) {
                    return true;
                }
                // subi找不到，放弃，回溯，继续寻找
                res.remove(res.size() - 1);
                endIdx += 1;
            }
        }
        else {
            String sums = String.valueOf(sum);
            int len = sums.length();
            if (idx + len <= S.length() && S.substring(idx, idx + len).equals(sums)) {
                res.add(sum);
                sum = res.get(res.size() - 2) + sum;
                if (backTrack(res, S, idx + len, sum)) {
                    return true;
                }
                else {
                    res.remove(res.size() - 1);
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitArrayIntoFibonacciSequence splitArrayIntoFibonacciSequence = new SplitArrayIntoFibonacciSequence();
        System.out.println(splitArrayIntoFibonacciSequence.splitIntoFibonacci("5511816597"));
    }
}
