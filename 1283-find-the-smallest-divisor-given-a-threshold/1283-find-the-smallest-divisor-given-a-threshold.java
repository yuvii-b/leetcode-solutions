class Solution {
    private int sumLogic(int[] nums, int divisor){
        int sum = 0, n = nums.length;
        for(int i = 0; i < n; ++i){
            sum += Math.ceil((double)nums[i] / divisor);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
       int n = nums.length;
       int maxi = Integer.MIN_VALUE;
       for(int num : nums){
            maxi = Math.max(num, maxi);
       }
       int low = 1, high = maxi;
       while(low <= high){
            int mid = low + (high - low) / 2;
            if(sumLogic(nums, mid) <= threshold){
                high = mid - 1;
            }else  low = mid + 1;
       }
       return low;
    }
}