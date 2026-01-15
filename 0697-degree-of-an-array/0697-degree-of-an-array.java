class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
        int res = 0, degree = 0, n = nums.length;
        for(int i = 0; i < n; ++i){
            first.putIfAbsent(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            int freq = count.get(nums[i]);
            if(freq > degree){
                degree = freq;
                res = i - first.get(nums[i]) + 1;
            }else if(freq == degree){
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }
        return res;
    }
}