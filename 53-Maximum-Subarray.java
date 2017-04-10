public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return Integer.MIN_VALUE;
        
        int presum = nums[0]; 
        int maxSum = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            if (presum <= 0) {
                presum = nums[i];
            } else {
                presum += nums[i];
            }
            maxSum = presum > maxSum ? presum : maxSum;
        }
        
        return maxSum;
    }
}
