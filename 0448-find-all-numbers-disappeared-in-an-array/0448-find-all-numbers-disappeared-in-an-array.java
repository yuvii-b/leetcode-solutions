class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0, n = nums.length;
        List<Integer> res = new ArrayList<>();
        while(i < n){
            if(nums[i] != nums[nums[i] - 1]) swap(nums, nums[i] - 1, i);
            else ++i;
        }
        for(int idx = 0; idx < n; ++idx){
            if(nums[idx] != idx + 1) res.add(idx + 1);
        }
        return res;
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}