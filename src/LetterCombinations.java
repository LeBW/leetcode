import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href=https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/>
 * Click to see online description
 * </a>
 * <br>
 * Using DFS to solve the problem.
 *
 * @author LBW
 */
public class LetterCombinations {
    private Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits.length() == 0)
            return results;
        //init the map
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        //using recursion to solve the DFS problem.
        StringBuilder builder = new StringBuilder();
        getString(digits, builder, results);
        return results;
    }

    private void getString(String digits, StringBuilder builder, List<String> results) {
        if (digits.length() == 0) {
            results.add(builder.toString());
            return;
        }
        char p = digits.charAt(0);
        digits = digits.substring(1);
        char[] charArr = map.get(p).toCharArray();

        for (char c: charArr) {
            StringBuilder tempBuilder = new StringBuilder(builder);
            tempBuilder.append(c);
            getString(digits, tempBuilder, results);
        }

    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }
}
