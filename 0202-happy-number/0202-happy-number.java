class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = square(slow);
            fast = square(square(fast));
        }while(slow != fast);
        return slow == 1;
    }

    private int square(int number){
        int ans = 0;
        while(number > 0){
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }
}