public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                while (low < high && nums[i] + nums[low] + nums[high] >= target) high--;
                result += high - low;
                low++;
            }
        }
        return result;
    }
}
