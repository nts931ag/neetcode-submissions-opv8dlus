class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int maxAbs = findAbsMax(nums);
        boolean[] existences = new boolean[maxAbs*2 + 1];
        for (int i = 0; i < nums.length; ++i) {
            if (existences[nums[i] + maxAbs]) {
                return true;
            }
            existences[nums[i] + maxAbs] = true;
        }
        return false;

    }

    public int findAbsMax(int[] nums) {
        int max = Math.abs(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            if (max < Math.abs(nums[i])) {
                max = Math.abs(nums[i]);
            }
        }
        return max;
    }
}