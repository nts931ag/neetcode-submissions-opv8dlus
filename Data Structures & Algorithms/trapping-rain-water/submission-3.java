class Solution {
    public int trap(int[] height) {
        int[] preFixMaxElement = new int[height.length];
        int[] postFixMaxElement = new int[height.length];
        int max = 0;
        preFixMaxElement[0] = max;
        for (int i = 1; i < height.length; ++i) {
            if (max < height[i-1]) {
                max = height[i-1];
            }
            preFixMaxElement[i] = max;
        }

        max = 0;
        postFixMaxElement[height.length - 1] = max;
        for (int i = height.length - 2; i >= 0; --i) {
            if (max < height[i+1]) {
                max = height[i+1];
            }
            postFixMaxElement[i] = max;
        }
        int res = 0;
        for (int  i = 0; i < height.length; ++i) {
            int currentValue = Math.min(preFixMaxElement[i], postFixMaxElement[i]) - height[i];
            if (currentValue > 0) {
            res += currentValue;
            }
        }

        return res;
    }
}
