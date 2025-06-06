class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = search(nums, target, true);
        res[1] = search(nums, target, false);
        return res;
    }

    private int search(int[] nums, int target, boolean flag){
        int start = 0, end = nums.length - 1, index = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                index = mid;
                if(flag) end = mid - 1;
                else start = mid + 1;
            }
            else if(nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return index;
    }
}