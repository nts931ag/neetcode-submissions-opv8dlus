public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < nums.length; ++i) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<List<Integer>> freq = new ArrayList<>();

        for (int i = 0; i <= nums.length; ++i) {
            List<Integer> numbers = new ArrayList<>();
            freq.add(numbers);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq.get(entry.getValue()).add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = freq.size() - 1; i > 0 && index <= k; i--) {
            for (int j = 0; j < freq.get(i).size(); j++) {
                res[index++] = freq.get(i).get(j);
                if (index == k) {
                    return res;
                }
            }
        }

        return res;
    }
}