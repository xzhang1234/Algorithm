public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> valueIndexPair = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (valueIndexPair.containsKey(target - nums[i])) {
                result[0] = valueIndexPair.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                valueIndexPair.put(nums[i], i);
            }
        }
        return result;
    }
}
