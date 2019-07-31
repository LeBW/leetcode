/**
 * 外层n-1次循环
 * 内部根据每一次cur遍历一次循环得到next
 * @author LBW
 */
public class CountAndSay {
    public String countAnySay(int n) {
        String cur = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int j = 0;
            int count = 0;
            while (j < cur.length()) {
                char target = cur.charAt(j);
                while (j < cur.length() && target == cur.charAt(j)) {
                    count++;
                    j++;
                }
                next.append(count);
                next.append(target);
                count = 0;
            }
            cur = next.toString();
        }
        return cur;
    }
}
