class Solution {
    public int reverse(int x) {
        int reverseNum = 0;
        while(x != 0){
            int ld = x % 10;
            int temp = reverseNum * 10 + ld;
            if((temp - ld) / 10 != reverseNum) return 0;
            reverseNum = temp;
            x /= 10;
        }
        return reverseNum;
    }
}