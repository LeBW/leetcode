/**
 * 1720. Decode XORed Array
 * 位运算
 * @author LBW
 */
public class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] res = new int[n];
        res[0] = first;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}
