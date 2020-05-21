/**
 * @author LBW
 */
public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int num: nums) {
            if (isEvenDigit(num))
                evenCount++;
        }
        return evenCount;
    }

    private boolean isEvenDigit(int num) {
        int digit = 0;
        while (num > 0) {
            num = num / 10;
            digit += 1;
        }
        return digit % 2 == 0;
    }
}
