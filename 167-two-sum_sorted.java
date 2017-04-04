public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int p1 = 0, p2 = numbers.length - 1;
        while (p1 < p2) {
            if (numbers[p1] + numbers[p2] == target) {
                result[0] = p1 + 1; 
                result[1] = p2 + 1;
                break; 
            } else if (numbers[p1] + numbers[p2] < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return result; 
    }
}
