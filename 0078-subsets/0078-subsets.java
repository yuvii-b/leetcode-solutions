class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length, count = 1 << n;
        List<List<Integer>> subsets = new ArrayList<>();
        for(int i = 0; i < count; ++i){
            List<Integer> subset = new ArrayList<>();
            for(int j = 0; j < n; ++j){
                if(((i >> j) & 1) == 1){
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}