public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        
        boolean result = false;
        
        if (num%2 == 0) {
            result |= isUgly(num/2);
        }
        if (num%3 == 0) {
            result |= isUgly(num/3);
        }
        if (num%5 == 0) {
            result |= isUgly(num/5);
        }
        
        return result;
        
    }
}
