public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        
        Map<Character, Integer> nonRepeatChar = new HashMap<>();
        int start = 0, end = 0, maxLength = end - start;
        while (end < s.length()) {
            if (nonRepeatChar.containsKey(array[end])) {
                int newStart = nonRepeatChar.get(array[end]) + 1;
                for (int i = start; i < newStart; i++) {
                    nonRepeatChar.remove(array[i]);
                }
                start = newStart;
            } 
            nonRepeatChar.put(array[end], end);
            end++;
            if (end - start > maxLength) maxLength = end - start;
        }
        return maxLength;
    }
}
