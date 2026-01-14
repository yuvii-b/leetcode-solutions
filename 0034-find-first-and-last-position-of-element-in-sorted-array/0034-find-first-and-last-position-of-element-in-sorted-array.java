class Solution {
    private int search(int[] nums, int target, boolean isFirst){
        int n = nums.length, low = 0, high = n - 1, ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                ans = mid;
                if(isFirst) high = mid - 1;
                else low = mid + 1;
            }else if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = search(nums, target, true);
        if(first == -1) return new int[] {-1, -1};
        int second = search(nums, target, false);
        return new int[] {first, second};
    }
}