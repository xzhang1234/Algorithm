public class Solution {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isVowel(array[left])) {
                left++;
            } else if (!isVowel(array[right])) {
                right--;
            } else {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return new String(array);
    }
    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ||
        (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}
