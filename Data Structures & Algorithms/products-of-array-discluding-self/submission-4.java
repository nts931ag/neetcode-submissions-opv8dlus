class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        int[] preFix = new int[size];
        int[] postFix = new int[size];
        preFix[0] = 1;
        for (int i = 1; i < size; ++i) {
            preFix[i] = preFix[i-1] * nums[i-1]; 
        }
        postFix[size-1] = 1;
        for (int i = size-2; i >= 0; --i) {
            postFix[i] = postFix[i+1] * nums[i+1];
        }

        for (int i = 0; i < size; ++i) {
            res[i] = preFix[i] * postFix[i];
        }

        return res;
    }
}  
