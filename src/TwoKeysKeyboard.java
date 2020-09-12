/**
 * 650. 2 Keys Keyboard
 * @author LBW
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        //质因数分解
        int i = 2;
        int res = 0, cur = n;
        while (cur > 1) {
            while (cur % i == 0) {
                cur = cur / i;
                res += i;
            }
            i += 1;
        }
        return res;
    }
}
