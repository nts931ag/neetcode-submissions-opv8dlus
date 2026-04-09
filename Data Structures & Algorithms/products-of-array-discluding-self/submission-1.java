class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProducts = IntStream.range(0, nums.length)
                                .map(i -> 1)
                                .toArray();
        int[] rightProducts = IntStream.range(0, nums.length)
                                .map(i -> 1)
                                .toArray();
        for (int i = 0; i < nums.length; ++i) {
            for (int l = 0; l < i; l ++) {
                leftProducts[i] *= nums[l];
            }
            for (int r = nums.length - 1; r > i; --r) {
                rightProducts[i] *= nums[r];
            }
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < res.length; ++i) {
            res[i] = leftProducts[i] * rightProducts[i];
        }

        return res;

    }
}  
