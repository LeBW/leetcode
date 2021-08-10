package lcof;

/**
 * Offer 67. 把字符串转换为整数
 * 注意边界情况
 * @author LBW
 */
public class Offer67 {
    private final int boundry = Integer.MAX_VALUE / 10;
    public int strToInt(String str) {
        str = str.trim();
        char[] arr = str.toCharArray();
        if (arr.length == 0) {
            return 0;
        }
        int sign = 1;
        int idx = 0;
        if (arr[idx] == '-') {
            sign = -1;
            idx += 1;
        }
        else if (arr[idx] == '+') {
            idx += 1;
        }
        int res = 0;
        for (; idx < arr.length; idx++) {
            if (arr[idx] < '0' || arr[idx] > '9') {
                break;
            }
            int cur = arr[idx] - '0';
            if (res > boundry || (res == boundry && (cur > 7))) {  // 说明这次会产生溢出
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + cur;
        }
        return res * sign;
    }

    public static void main(String[] args) {
        Offer67 offer67 = new Offer67();
        System.out.println(offer67.strToInt("2147483648"));
    }
}
