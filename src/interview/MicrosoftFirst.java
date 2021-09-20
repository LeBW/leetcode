package interview;

public class MicrosoftFirst {
    public String solution(String S) {
        // write your code in Java SE 8
        char[] arr = S.toCharArray();
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left < right) {
            if (arr[left] == '?' && arr[right] == '?') {
                arr[left] = 'a';
                arr[right] = 'a';
            }
            else if (arr[left] == '?' && arr[right] != '?') {
                arr[left] = arr[right];
            }
            else if (arr[left] != '?' && arr[right] == '?') {
                arr[right] = arr[left];
            }
            else if (arr[left] != arr[right]){
                return "NO";
            }
            left += 1;
            right -= 1;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        MicrosoftFirst microsoftFirst = new MicrosoftFirst();
        microsoftFirst.solution("asdfasbsa");
    }
}
