import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation
 * @author LBW
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> result = new ArrayList<>();
        result.add(new StringBuilder());
        for (char c: S.toCharArray()) {
            int size = result.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < size; i++) {
                    result.add(new StringBuilder(result.get(i)));
                    result.get(i).append(Character.toLowerCase(c));
                    result.get(i + size).append(Character.toUpperCase(c));
                }
            }
            else {
                for (int i = 0; i < size; i++) {
                    result.get(i).append(c);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            ans.add(result.get(i).toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        letterCasePermutation.letterCasePermutation("a1b2");
    }
}
