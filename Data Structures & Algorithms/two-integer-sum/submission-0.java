class Solution {
    public int[] twoSum(int[] nums, int target) {
        int firstNumber = 0, secondNumber = 1; 
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int total = nums[i] + nums[j];
                if (total == target) {
                    firstNumber = i;
                    secondNumber = j;
                    break;
                }
            }
        }
        int[] result = {firstNumber, secondNumber};
        return result;
    }
}
