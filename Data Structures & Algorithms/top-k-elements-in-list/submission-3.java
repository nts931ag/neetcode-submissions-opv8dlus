class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        count.forEach((num, freq) -> {
            buckets[freq].add(num);
        });

        int[] result = new int[k];
        int currentIdx = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (currentIdx == k) {
                break;
            }
            for (int j = 0; j < buckets[i].size(); ++j) {
                if (currentIdx >= k) {
                    break;
                }
                result[currentIdx] = buckets[i].get(j);
                currentIdx++;
            }
        }

        return  result;
    }
}
