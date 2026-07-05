class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int ans = 0, best = nums[0];
        for(int j = k; j < nums.length; ++j){
            best = Math.max(best, nums[j - k]);
            ans = Math.max(ans, nums[j] + best);
        }
        return ans;
    }
}