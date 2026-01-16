class Solution {
    private long hoursTaken(int[] piles, int k){
        long n = piles.length, hours = 0;
        for(int i = 0; i < n; ++i){
            hours += (piles[i] + k - 1) / k;
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length, maxi = Integer.MIN_VALUE;
        for(int num : piles){
            if(num >= maxi) maxi = num;
        }
        int low = 1, high = maxi;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(hoursTaken(piles, mid) <= h){
                high = mid - 1;
            }else low = mid + 1;
        }
        return low;
    }
}