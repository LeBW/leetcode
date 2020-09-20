/**
 * 5519. Rearrange Spaces Between Words
 * 字符串
 * @author LBW
 */
public class RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split(" +");
        int spacesCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spacesCount += 1;
            }
        }
        StringBuilder builder = new StringBuilder();
        if (words.length == 1) {
            builder.append(words[0]);
            for (int i = 0; i < spacesCount; i++) {
                builder.append(" ");
            }
            return builder.toString();
        }
        int averageSpaces = spacesCount / (words.length - 1);
        int extraSpaces = spacesCount % (words.length - 1);
        builder.append(words[0]);
        for (int k = 1; k < words.length; k++) {
            for (int i = 0; i < averageSpaces; i++) {
                builder.append(" ");
            }
            builder.append(words[k]);
        }
        for (int i = 0; i < extraSpaces; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        RearrangeSpacesBetweenWords rearrangeSpacesBetweenWords = new RearrangeSpacesBetweenWords();
        rearrangeSpacesBetweenWords.reorderSpaces("  this   is  a sentence ");
    }
}
