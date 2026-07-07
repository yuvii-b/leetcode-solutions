class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0, x = 0;
        int pos = 1, temp = n;
        while(temp > 0){
            int d = temp % 10;
            temp /= 10;
            sum += d;
            if(d != 0){
                x = x + pos * d;
                pos *= 10;
            }
        }
        return sum * x;
    }
}