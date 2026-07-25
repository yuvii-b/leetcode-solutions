class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0, idx = -1, n = nums.length;
        for(int i = 0; i < n - 1; ++i){
            if(nums[i] >= nums[i + 1]){
                ++count;
                idx = i;
            }
        }
        if(count > 1) return false;
        if(count == 0) return true;
        if(idx == 0 || idx == n - 2) return true;
        return nums[idx - 1] < nums[idx + 1] || nums[idx] < nums[idx + 2]; 
    }
}