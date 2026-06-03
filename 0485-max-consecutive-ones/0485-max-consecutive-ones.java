class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, l = 0, r = 0, len = 0;
        while(r < n){
            if(nums[r] == 0) l = r + 1;
            len = Math.max(r - l + 1, len);
            ++r; 
        }
        return len;
    }
}