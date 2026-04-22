class Solution {
    public int trap(int[] height) {
        int l, r;
        int res = 0;
        for (int i = 0; i < height.length; ++i) {
            int minLeft = findGreatestOnLeftSide(height, i);
            int minRight = findGreatestOnRightSide(height, i);
            int currentValue = Math.min(minLeft, minRight) - height[i];
            if (currentValue > 0) {
                res += currentValue;
            }
        }
        return res;
    }

    private int findGreatestOnLeftSide(int[] height, int boundary) {
        if (boundary == 0) {
            return height[boundary];
        }
        int max = 0;
        for (int i = 0; i < boundary; ++i) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

    private int findGreatestOnRightSide(int[] height, int boundary) {
        if (boundary == height.length - 1) {
            return height[boundary];
        }
        int max = 0;
        for (int i = height.length - 1; i > boundary; --i) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }
}
