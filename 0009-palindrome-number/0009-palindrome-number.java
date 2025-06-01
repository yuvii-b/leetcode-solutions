class Solution {
    public boolean isPalindrome(int x) {
        // int rev = 0;
        // if(x < 0) return false;
        // int n = x;
        // while(x > 0){
        //     rev = (rev * 10) + (x % 10);
        //     x /= 10;
        // }
        // return n == rev;

        //without extra space
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while(x > rev){
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }
}