class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length, currMax = nums[0], currMin = nums[0], maxSum = nums[0], minSum = nums[0], total = nums[0];
        for(int i = 1; i < n; ++i){
            currMax = Math.max(nums[i], currMax + nums[i]);
            currMin = Math.min(nums[i], currMin + nums[i]);
            maxSum = Math.max(currMax, maxSum);
            minSum = Math.min(currMin, minSum);
            total += nums[i];
        } 
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}