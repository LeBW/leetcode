package interview;

/**
 * @author LBW
 */
public class Test {
    public int numberOfCoins(int target) {
        int result = 0;
        int i = 0, j = 0;
        for (i = 0; i * 2 <= target; i++) {
            for (j = 0; i * 2 + j * 5 <= target; j++) {
                result += 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.numberOfCoins(6));
    }
}
