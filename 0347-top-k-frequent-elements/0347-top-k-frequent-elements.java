class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> arr = new ArrayList<>(map.entrySet());
        arr.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        int[] ans = new int[k];
        for(int i = 0; i < k; ++i){
            ans[i] = arr.get(i).getKey();
        }
        return ans;
    }
}