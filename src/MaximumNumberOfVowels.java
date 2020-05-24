/**
 * 5417. Maximum Number of Vowels in a Substring of Given Length
 * @author LBW
 */
public class MaximumNumberOfVowels {
    private String vowels = "aeiou";
    public int maxVowels(String s, int k) {
        int len = s.length();
        boolean[] vowels = new boolean[len];
        int cur = 0;
        int i = 0;
        for (i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowels[i] = true;
                cur += 1;
            }
        }
        int max = cur;
        for (; i < len; i++) {
            if (isVowel(s.charAt(i))) {
                vowels[i] = true;
                cur += 1;
            }
            if (vowels[i-k])
                cur -= 1;
            if (cur > max)
                max = cur;
        }
        return max;
    }

    private boolean isVowel(char c) {
        return vowels.indexOf(c) != -1;
    }

    public static void main(String[] args) {
        MaximumNumberOfVowels maximumNumberOfVowels = new MaximumNumberOfVowels();
        System.out.println(maximumNumberOfVowels.maxVowels("aeiou", 2));
    }
}
