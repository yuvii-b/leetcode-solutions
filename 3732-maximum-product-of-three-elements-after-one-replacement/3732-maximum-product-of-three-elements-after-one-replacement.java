class Solution {
    public long maxProduct(int[] nums) {
        long max1 = 0, max2 = 0;
        for(int n : nums){
            long num = Math.abs(n);
            if(num >= max1){
                max2 = max1;
                max1 = num;
            }else if(num > max2) max2 = num;
        }
        return max1 * max2 * 100000;
    }
}