class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0, end = arr.length, m;
        while(start < end){
            m = (start + end) / 2;
            if(arr[m] - 1 - m < k) start = m + 1;
            else end = m;
        }
        return start + k;
    }
}