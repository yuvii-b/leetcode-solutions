class Solution {
    public int[] findErrorNums(int[] nums) {
        int xr = 0, n = nums.length;
        for(int i = 0; i < nums.length; ++i){
            xr ^= nums[i];
            xr ^= (i + 1);
        }
        int setBit = xr & -xr;
        int one = 0, zero = 0;
        for(int i = 0; i < n; ++i){
            if((nums[i] & setBit) != 0) one ^= nums[i];
            else zero ^= nums[i];
            if(((i + 1) & setBit) != 0) one ^= (i + 1);
            else zero ^= (i + 1);
        }
        int count = 0;
        for(int i = 0; i < n; ++i){
            if(zero == nums[i]) ++count;
        }
        if(count == 2) return new int[]{zero, one};
        return new int[]{one, zero};
    }
}