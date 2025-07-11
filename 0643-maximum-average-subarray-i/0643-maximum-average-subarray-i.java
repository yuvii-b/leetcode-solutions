class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0; i < k; ++i){
            sum += nums[i];
        }
        double avg = sum / k;
        int l = 0;
        for(int i = k; i < nums.length; ++i){
            sum += nums[i];
            sum -= nums[l++];
            avg = Math.max(avg, sum/k);
        }
        return avg;
    }
}