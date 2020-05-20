/**
 * @author LBW
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        boolean result = true;
        int len = word.length();

        boolean first = isCapital(word.charAt(0));
        if (first) {
            for (int i = 1; i < len - 1; i++) {
                if (isCapital(word.charAt(i)) != isCapital(word.charAt(i+1))) {
                    return false;
                }
            }
            return true;

        }
        else {
            for (int i = 1; i < len; i++) {
                if (isCapital(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean isCapital(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    /**
     * Method 2: Regex
     * @param word
     * @return
     */
    public boolean detectCapitalUseTwo(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z]?[a-z]+");
    }
}
