class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if(n < 0){
            n = -(n + 1);
            x = 1 / x;
            ans *= x;
        }
        while(n > 0){
            if(n % 2 == 1){
                n -= 1;
                ans *= x;
            }else{
                n /= 2;
                x *= x;
            }
        }
        return ans;
    }
}