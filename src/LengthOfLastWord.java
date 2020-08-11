/**
 * 58. Length of Last Word
 * @author LBW
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // 首先过滤末尾的空格
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ')
            i--;
        // 然后数最后一个单词的长度即可
        int res = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            res += 1;
            i -= 1;
        }
        return res;
    }
}
