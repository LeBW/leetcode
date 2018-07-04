/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * @author LBW
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)  //negative number is not a palindrome.
            return false;
        int cur = x;
        int inverse = 0;
        while (cur != 0) {
            int t = cur % 10;
            cur = cur / 10;
            inverse = inverse * 10 + t;
        }
        if (inverse != x)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(123));
    }
}
