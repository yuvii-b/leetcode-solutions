class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int countPairs(int[] arr, int low, int mid, int high){
        int right = mid + 1, count = 0;
        for(int i = low; i <= mid; ++i){
            while(right <= high && arr[i] > 2L * arr[right]) ++right;
            count += (right - (mid + 1));
        }
        return count;
    }

    private int mergeSort(int[] arr, int low, int high){
        int mid = low + (high - low) / 2, count = 0;
        if(low >= high) return count;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high); 
        return count;
    }

    private void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, idx = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]) temp[idx++] = arr[left++];
            else temp[idx++] = arr[right++];
        }
        while(left <= mid) temp[idx++] = arr[left++];
        while(right <= high) temp[idx++] = arr[right++];
        for(int i = low; i <= high; ++i){
            arr[i] = temp[i - low];
        }
    }
}