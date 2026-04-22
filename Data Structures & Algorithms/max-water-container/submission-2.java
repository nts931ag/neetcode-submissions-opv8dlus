class Solution {
    public int maxArea(int[] heights) {
        int length = heights.length;
        int maxValue = 0;
        for (int i = 0; i < length - 1; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp;
                int width = j - i;
                if (heights[i] < heights[j]) {
                    temp = heights[i] * width;
                } else {
                    temp = heights[j] * width;
                }
                if (temp > maxValue) {
                    maxValue = temp;
                }
            }
        }
        return maxValue;
    }
}
