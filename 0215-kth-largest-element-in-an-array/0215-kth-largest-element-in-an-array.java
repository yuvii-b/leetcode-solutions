class Solution {
    // use min heap preferrably, this is quick select, for even more efficiency, randomize the pivot
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

     private int quickSelect(int[] nums, int low, int high, int k) {
        while (low <= high) {
            int pivot = partition(nums, low, high);
            if (pivot == k) return nums[pivot];
            else if (pivot > k) high = pivot - 1;
            else low = pivot + 1;
        }
        return -1;
    }

    private int partition(int[] arr, int low, int high) {
        int i = low, j = high;
        Random rand = new Random();
        int random = low + rand.nextInt(high - low + 1);
        swap(arr, random, low);
        int pivot = arr[low];
        while (i < j) {
            while (arr[i] <= pivot && i < high) i++;
            while (arr[j] > pivot && j > low) j--;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}