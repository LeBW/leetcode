package interview;

/**
 * @author LBW
 */
public class Shopee1 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param param string字符串
     * @return string字符串
     */
    public String compressString(String param) {
        // write code here
        int length = param.length();
        if (length == 0)
            return param;
        StringBuilder res = new StringBuilder();
        char last = param.charAt(0);
        int cnt = 1;
        for (int i = 1; i < length; i++) {
            if (param.charAt(i) == last) {
                cnt += 1;
            }
            else {
                res.append(last);
                if (cnt > 1)
                    res.append(cnt);
                last = param.charAt(i);
                cnt = 1;
            }
        }
        res.append(last);
        if (cnt > 1)
            res.append(cnt);
        return res.toString();
    }
}
