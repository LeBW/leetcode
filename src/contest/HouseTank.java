package contest;

/**
 * @author LBW
 */
public class HouseTank {

    public static void main(String[] args) {
        HouseTank houseTank = new HouseTank();
        System.out.println(houseTank.compress("aabbbbbcdd"));
    }

    private String compress(String s) {
        int len = s.length();
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == len - 1 || s.charAt(i) != s.charAt(i + 1)) {
                count += 1;
                if (count > 1)
                    builder.append(count);
                builder.append(s.charAt(i));
                count = 0;
            }
            else {
                count += 1;
            }
        }
        return builder.toString();
    }
}
