class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if(n < 0){
            n = -(n + 1);
            x = 1 / x;
            ans *= x;
        }
        while(n > 0){
            if((n & 1) == 1){
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}