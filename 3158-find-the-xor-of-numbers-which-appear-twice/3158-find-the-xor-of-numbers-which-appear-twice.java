class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int result = 0;
        long seen = 0;
        for(int num : nums){
            if(((seen >> num) & 1) == 1) result ^= num;
            else seen |= (1L << num);
        }
        return result;
    }
}