class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        for (int i = 0; i < height.length; ++i) {
            int l = 0;
            int r = height.length - 1;
            int max = 0;
            while (l < i) {
                if (max < height[l]) {
                    max = height[l];
                }
                l++;
            }
            prefix[i] = max;
            max = 0;
            while (r > i) {
                if (max < height[r]) {
                    max = height[r];
                }
                r--;
            }
            suffix[i] = max;
        }
        int res = 0;

        for (int i = 0; i < height.length; ++i) {
            int temp = Math.min(prefix[i], suffix[i]) - height[i];
            if (temp > 0) {
                res += temp;
            }
        }
        
        return res;
    }
}
