class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length, middle = nums[n / 2], freq = 0;
        for(int num : nums){
            if(num == middle) ++freq;
        }
        return freq == 1;
    }
}