class Solution {
    // TC - O(N), SC - O(1) -> change while to if.. note the reason for optimization
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, zeros = 0, len = 0;
        while(r < n){
            if(nums[r] == 0) ++zeros;
            if(zeros > k){
                if(nums[l] == 0) --zeros;
                ++l;
            }
            len = Math.max(len, r - l + 1);
            ++r;
        }
        return len;
    }
}