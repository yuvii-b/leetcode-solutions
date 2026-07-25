class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, i = 0;
        while(i < n){
            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                swap(nums,i, nums[i] - 1);
            } else ++i;
        }
        return find(nums, n);
    }

    private int find(int[] nums, int n){
        for(int i = 0; i < n; ++i){
            if(nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}