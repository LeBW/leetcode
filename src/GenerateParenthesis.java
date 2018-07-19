import java.util.ArrayList;
import java.util.List;

/**
 * @author LBW
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();

        getStrings("", 0, n, results);

        return results;
    }

    private void getStrings(String cur, int stack, int n, List<String> results) {
        //if length is 2n, return the string.
        if (cur.length() == 2*n) {
            results.add(cur);
            return;
        }
        //if the stack is zero, means that there is no remaining '(' in string, so we can only add a '('.
        if (stack == 0) {
            getStrings(cur+'(', stack+1, n, results);
        }

        else {
            if (charCount('(', cur) < n)
                getStrings(cur+'(', stack+1, n, results);
            getStrings(cur + ')', stack-1, n, results);
        }
    }

    private int charCount(char c, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i))
                count++;
        }
        return count;
    }
}
