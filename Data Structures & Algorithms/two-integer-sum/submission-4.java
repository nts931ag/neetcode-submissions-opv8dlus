class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int difference = target - nums[i];
            if (valueIndexMap.containsKey(difference)) {
                return new int[]{valueIndexMap.get(difference), i};
            } else {
                valueIndexMap.put(nums[i], i);
            }
        }
        return new int[]{0, 1};
    }
}
