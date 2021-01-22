import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 989. Add to Array-Form of Integer
 * @author LBW
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int[] B = intToArray(K);
        return arrayAddArray(A, B);
    }

    private int[] intToArray(int k) {
        List<Integer> res = new LinkedList<>();
        while (k != 0) {
            res.add(0, k % 10);
            k = k / 10;
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private List<Integer> arrayAddArray(int[] A, int[] B) {
        int n1 = A.length, n2 = B.length;
        List<Integer> res = new LinkedList<>();
        int i = A.length - 1, j = B.length - 1, carry = 0;
        while (i >= 0 && j >= 0) {
            int a = A[i], b = B[j];
            int t = a + b + carry;
            carry = t >= 10 ? 1 : 0;
            t = t % 10;
            res.add(0, t);
            i--;
            j--;
        }
        while (i >= 0) {
            int t = A[i] + carry;
            carry = t >= 10 ? 1 : 0;
            t = t % 10;
            res.add(0, t);
            i--;
        }
        while (j >= 0) {
            int t = B[j] + carry;
            carry = t >= 10 ? 1 : 0;
            t = t % 10;
            res.add(0, t);
            j--;
        }
        if (carry == 1) {
            res.add(0, 1);
        }
        return res;
    }
}
