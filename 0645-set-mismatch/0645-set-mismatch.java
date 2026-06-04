class Solution {
    public int[] findErrorNums(int[] nums) {
        int repeating = -1, missing = -1, n = nums.length;
        int[] count = new int[n + 1];
        for(int i = 0; i < n; ++i){
            count[nums[i]]++;
        }
        for(int i = 1; i <= n; ++i){
            if(count[i] == 2) repeating = i;
            else if(count[i] == 0) missing = i;
            if(repeating != -1 && missing != -1) break;
        }
        return new int[]{repeating, missing};
    }
}