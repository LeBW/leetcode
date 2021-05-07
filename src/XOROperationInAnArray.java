/**
 * 1486. XOR Operation in an Array
 * 位运算
 * @author LBW
 */
public class XOROperationInAnArray {
    public int xorOperation(int n, int start) {
        int res = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            cur = start + i * 2;
            res ^= cur;
        }
        return res;
    }
}