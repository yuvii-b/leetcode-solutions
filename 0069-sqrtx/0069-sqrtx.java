class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int low = 1, high = x;
        while(low <= high){
            int mid = low + (high - low) / 2;
            long midSquared = (long) mid * mid;
            if(midSquared == x) return mid;
            else if(midSquared > x) high = mid - 1;
            else low = mid + 1;
        }
        return high;
    }
}