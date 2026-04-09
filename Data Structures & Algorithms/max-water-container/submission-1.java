class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxAmountOfWater = 0;
        while (l < r) {
            int currentAmountOfWater = (r - l) * Math.min(heights[l], heights[r]);
            if (currentAmountOfWater > maxAmountOfWater) {
                maxAmountOfWater = currentAmountOfWater;
            }
            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxAmountOfWater;
    }
}
