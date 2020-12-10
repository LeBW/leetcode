/**
 * 860. Lemonade Change
 * @author LBW
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] remains = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                remains[0] += 1;
            }
            else if (bills[i] == 10) {
                if (remains[0] == 0) {
                    return false;
                }
                else {
                    remains[0] -= 1;
                    remains[1] += 1;
                }
            }
            else {  // bills[i] == 20
                int need = 15;
                if (remains[1] > 0) {
                    need -= 10;
                    remains[1] -= 1;
                }
                while (need > 0 && remains[0] > 0) {
                    remains[0] -= 1;
                    need -= 5;
                }
                if (need > 0)
                    return false;
            }
        }
        return true;
    }
}
