/**
 * @author LBW
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] dict = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int index = 0;
        while (!s.equals("")) {
            int targetSize = dict[index].length();
            if (s.length() < targetSize) {
                index++;
                continue;
            }
            String target = s.substring(0, targetSize);

            if (target.equals(dict[index])) {
                s = s.substring(targetSize);
                result += nums[index];
            }
            else {
                index++;
            }
        }
        return result;
    }
}
