class Solution {
    // count array - interesting
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int ans = 0, n = arr.length;
        int[] count = new int[n + 1];
        for(int num : arr){
            ++count[Math.min(num, n)];
        }
        for(int i = 1; i <= n; ++i){
            ans = Math.min(i, ans + count[i]);
        }
        return ans;
    }
}