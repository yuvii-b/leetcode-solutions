class Solution {
    int[] ans;
    class Pair{
        int val, idx;
        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        ans = new int[n];
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; ++i){
            arr[i] = new Pair(nums[i], i);
        }
        mergeSort(arr, 0, n - 1);
        for(int num : ans){
            res.add(num);
        }
        return res;
    }

    private void mergeSort(Pair[] arr, int low, int high){
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high); 
    }

    private void merge(Pair[] arr, int low, int mid, int high){
        Pair[] temp = new Pair[high - low + 1];
        int left = low, right = mid + 1, idx = 0;
        while(left <= mid && right <= high){
            if(arr[left].val <= arr[right].val) temp[idx++] = arr[right++]; // descending
            else{
                ans[arr[left].idx] += (high - right + 1);
                temp[idx++] = arr[left++];
            }
        }
        // here normal
        while(left <= mid){
            temp[idx++] = arr[left++];
        }
        while(right <= high){
            temp[idx++] = arr[right++];
        }
        for(int i = low; i <= high; ++i){
            arr[i] = temp[i - low];
        }
    }
}