class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            numSet.add(nums[i]);
        }
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!numSet.contains(nums[i] - 1)) {
                int start = nums[i];
                int sequenceLength = 1;
                for (int j = 0; j < nums.length; ++j) {
                    start += 1;
                    if (numSet.contains(start)) {
                        sequenceLength += 1;
                    } else {
                        break;
                    }
                }
                result.add(sequenceLength);
            }
        }
        return result.stream().max(Integer::compareTo).get();
    }
}
