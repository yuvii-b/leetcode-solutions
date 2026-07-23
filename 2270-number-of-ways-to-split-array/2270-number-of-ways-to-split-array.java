class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length, count = 0; 
        long leftSum = 0, total = 0;
        for(int num : nums) total += num;
        for(int i = 0; i < n - 1; ++i){
            leftSum += nums[i];
            if(leftSum >= total - leftSum) ++count;
        }
        return count;
    }
}