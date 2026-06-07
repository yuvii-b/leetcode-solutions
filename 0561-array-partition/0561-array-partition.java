class Solution {
    public int arrayPairSum(int[] nums) {
        int n = nums.length, count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n; i += 2){
            count += nums[i];
        }
        return count;
    }
}