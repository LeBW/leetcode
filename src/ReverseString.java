/**
 * 344. Reverse String
 * @author LBW
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        char tmp;
        while (i < j) {
            // swap s[i] and s[j]
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
