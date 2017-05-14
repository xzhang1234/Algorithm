public class Solution {
    
    Map<Character, String> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', " ");

        helper(new String(), digits, 0, results);
        
        return results;
    }
    
    private void helper(String letters, 
                        String digits,
                        int position,
                        List<String> results) {
        if (position == digits.length()) {
            results.add(new String(letters));
            return;
        }
        
        for (char c : map.get(digits.charAt(position)).toCharArray()) {
            letters += c;
            helper(letters, digits, position + 1, results);
            letters = letters.substring(0, letters.length() - 1);
        }
                            
    }

}
