package lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归进行全排列（考虑大数）
 * @author LBW
 */
public class Offer17 {
    // 方法一，没有考虑大数
    public int[] printNumbers(int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = max * 10 + 9;
        }
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }
    // 方法二，考虑使用大数，因此要使用递归进行枚举
    public int[] printNumbersTwo(int n) {
        char[] str = new char[n];
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str[i] = '0';
        }
        dfs(str, 0, arr);
        int[] res = new int[arr.size() - 1];
        for (int i = 1; i < arr.size(); i++) { // 从 1 开始，略去第一个数 0.
            res[i - 1] = Integer.parseInt(arr.get(i));
        }
        return res;
    }

    private void dfs(char[] str, int index, List<String> arr) {
        if (index == str.length) {
            arr.add(new String(str));
            return;
        }
        for (int i = 0; i < 10; i++) {
            str[index] = (char)('0' + i);
            dfs(str, index + 1, arr);
        }
    }

    public static void main(String[] args) {
        Offer17 offer17 = new Offer17();
        offer17.printNumbersTwo(3);
    }
}
