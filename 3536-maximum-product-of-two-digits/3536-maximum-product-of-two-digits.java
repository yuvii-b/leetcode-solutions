class Solution {
    public int maxProduct(int n) {
        int first = 0, second = 0, temp = n;
        while(temp > 0){
            int digit = temp % 10;
            if(digit > first){
                second = first;
                first = digit;
            }else if(digit > second) second = digit;
            temp /= 10;
        }
        return first * second;
    }
}