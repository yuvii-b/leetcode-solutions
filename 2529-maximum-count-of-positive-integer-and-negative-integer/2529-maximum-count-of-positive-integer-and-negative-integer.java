class Solution {
    private int lowerBound(int[] nums, int n, int target){
        int low = 0, high = n - 1, ans = n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return ans;
    }
    public int maximumCount(int[] nums) {
        int n = nums.length;
        return Math.max(lowerBound(nums, n, 0), n - lowerBound(nums, n, 1));
    }
}