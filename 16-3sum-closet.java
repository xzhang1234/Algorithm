public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closet = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == target) return target;
                    if (Math.abs(target - sum) < Math.abs(target - closet)) 
                        closet = sum;
                    if (sum < target) low++;
                    else high--; 
                }
            }
        }
        return closet;
    }
}
