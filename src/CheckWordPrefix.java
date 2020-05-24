import java.util.HashSet;
import java.util.Set;

/**
 * 5416. Check If a Word Occurs As a Prefix of Any Word in a Sentence
 * @author LBW
 */
public class CheckWordPrefix {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (isPrefix(words[i], searchWord)) {
                return i+1;
            }
        }
        return -1;
    }

    private boolean isPrefix(String word, String search) {
        if (word.length() < search.length()) {
            return false;
        }
        for (int i = 0; i < search.length(); i++) {
            if (word.charAt(i) != search.charAt(i))
                return false;
        }
        return true;
    }
}
