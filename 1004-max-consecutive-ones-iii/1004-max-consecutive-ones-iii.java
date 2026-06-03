class Solution {
    // TC - O(N), SC - O(1) -> change while to if and remove max, len.. note the reason for optimization
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, zeros = 0;
        while(r < n){
            if(nums[r] == 0) ++zeros;
            if(zeros > k){
                if(nums[l] == 0) --zeros;
                ++l;
            }
            ++r;
        }
        return r - l;
    }
}