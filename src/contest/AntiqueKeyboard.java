package contest;

import java.util.Arrays;

/**
 * @author LBW
 */
public class AntiqueKeyboard {
    private int res = 0;
    public int keyboard(int k, int n) {
        int[] params = new int[k+1];
        res = 0;
        dfs(params, 0, 26,  k, n);
        return res;
    }

    private void dfs(int[] params, int idx, int left, int k, int n) {
        if (idx == k) {
            // 最后一个系数，不用遍历，剩下的全给他就行
            params[idx] = left;
            // 开始计算是否满足
            int sum = 0;
            for (int i = 0; i <= k; i++) {
                sum += i * params[i];
            }
            if (sum == n) {  // 如果满足的话，开始计算值
                int tmp = 1;
                int l = 26;
                for (int i = 0; i <= k; i++) {
                    tmp *= helper(l, params[i]);
                    l -= params[i];
                }
                tmp *= factorial(n);
                for (int i = 2; i <= k; i++) {
                    tmp /= (int)Math.pow(factorial(i), params[i]);
                }
                res += tmp;
            }
            return;
        }
        for (int i = 0; i <= left; i++) {
            params[idx] = i;
            dfs(params, idx+1, left - i, k, n);
        }
    }

    private int helper(int l, int param) {
        if (param > l / 2) {
            param = l - param;
        }
        int r = 1, cur = l;
        for (int i = 0; i < param; i++) {
            r *= cur;
            cur -= 1;
        }
        return r / factorial(param);
    }

    private int factorial(int n) {
        int res = 1;
        while (n >= 2) {
            res *= n;
            n -= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        AntiqueKeyboard antiqueKeyboard = new AntiqueKeyboard();
        System.out.println(antiqueKeyboard.keyboard(2, 2));
    }
}
