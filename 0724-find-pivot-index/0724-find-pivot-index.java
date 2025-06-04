class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int n : nums){
            total += n;
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; ++i){
            int rightSum = total - leftSum - nums[i];
            if(rightSum == leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}