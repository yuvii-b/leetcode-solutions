class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
        int res = 0, degree = 0, n = nums.length;
        for(int i = 0; i < n; ++i){
            first.putIfAbsent(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            int freq = count.get(nums[i]), len = i - first.get(nums[i]) + 1;
            if(freq > degree){
                degree = freq;
                res = len;
            }else if(freq == degree){
                res = Math.min(res, len);
            }
        }
        return res;
    }
}