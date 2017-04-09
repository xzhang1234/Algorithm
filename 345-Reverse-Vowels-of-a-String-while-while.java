public class Solution {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isVowel(array[left])) {
                left++;
            }
            while (left < right && !isVowel(array[right])) {
                right--;
            }
            
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            left++;
            right--;
        }
        return new String(array);
    }
    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ||
        (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}
