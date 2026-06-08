class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length, idx = 0;
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            if(nums[i] > pivot) greater.add(nums[i]);
            else if(nums[i] < pivot) less.add(nums[i]);
            else equal.add(nums[i]);
        }
        int[] ans = new int[n];
        for(int num : less) ans[idx++] = num;
        for(int num : equal) ans[idx++] = num;
        for(int num : greater) ans[idx++] = num;
        return ans;
    }
}