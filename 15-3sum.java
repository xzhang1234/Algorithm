public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int p1 = i + 1, p2 = nums.length - 1;
                while (p1 < p2) {
                    if (nums[i] + nums[p1] + nums[p2] == 0) {
                        result.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                        while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                        while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                        p1++;
                        p2--;
                    } else if (nums[i] + nums[p1] + nums[p2] < 0) {
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
