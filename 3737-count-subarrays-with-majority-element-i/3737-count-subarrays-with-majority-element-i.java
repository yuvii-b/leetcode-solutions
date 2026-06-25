class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length, res = 0;
        for(int i = 0; i < n; ++i){
            int len = 0, count = 0;
            for(int j = i; j < n; ++j){
                if(nums[j] == target) ++count;
                ++len;
                if(2 * count > len) ++res;
            }
        }
        return res;
    }
}