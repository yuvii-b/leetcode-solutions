class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length, i = 0;
        while(i < n){
            if(nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
            else ++i;
        }
        for(i = 0; i < n; ++i){
            if(nums[i] != i + 1) res.add(nums[i]);
        }
        return res;
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}