class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0, j = n - 1, left = 0, right = n - 1;
        while(i < n){
            if(nums[i] < pivot) ans[left++] = nums[i];
            if(nums[j] > pivot) ans[right--] = nums[j];
            ++i; --j;
        }
        while(left <= right) ans[left++] = pivot;
        return ans;
    }
}