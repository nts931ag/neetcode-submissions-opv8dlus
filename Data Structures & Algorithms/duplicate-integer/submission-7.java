class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int max = Arrays.stream(nums).map(a -> Math.abs(a)).max().getAsInt();
        int[] freqs = new int[max*2 + 1];
        for (int i = 0; i < nums.length; ++i) {
            freqs[nums[i] + max] += 1;
        }
        for (int i = 0; i < freqs.length; ++i) {
            if (freqs[i] > 1) {
                return true;
            }
        }
        return false;
    }
}