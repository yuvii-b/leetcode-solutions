class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length, low = 0, high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int missingCount = arr[mid] - (mid + 1);
            if(missingCount < k) low = mid + 1;
            else high = mid - 1;
        }
        return low + k;
    }
}