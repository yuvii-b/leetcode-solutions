class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE, high = 0;
        for(int i = 0; i < n; ++i){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        while(low <= high){
            int mid = low + (high - low) / 2, need = 1, curr = 0;
            for(int w : weights){
                if(curr + w > mid){
                    need += 1;
                    curr = 0;
                }
                curr += w;
            }
            if(need > days) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}