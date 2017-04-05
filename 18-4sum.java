public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 3; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            for (int i = k + 1; i < nums.length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) continue;
                int p1 = i + 1, p2 = nums.length - 1;
                while (p1 < p2) {
                    int sum = nums[k] + nums[i] + nums[p1] + nums[p2];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[p1], nums[p2]));
                        while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                        while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                        p1++;
                        p2--;
                    } else if (sum < target) {
                        p1++;    
                    } else {
                        p2--;
                    }
                }
            }
        }
        return result;
    }
}
