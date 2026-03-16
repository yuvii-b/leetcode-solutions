class Solution {
    public int[] singleNumber(int[] nums) {
        long xorr = 0;
        for(int n : nums){
            xorr ^= n;
        } 
        int rightmost = (int)(xorr & (xorr - 1)) ^ (int)xorr;
        int b1 = 0, b2 = 0;
        for(int n : nums){
            if((n & rightmost) != 0) b1 ^= n;
            else b2 ^= n;
        }
        return new int[]{b1, b2};
    }
}