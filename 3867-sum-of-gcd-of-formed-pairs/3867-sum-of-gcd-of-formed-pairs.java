class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        int[] preGcd = new int[n];
        for(int i = 0; i < n; ++i){
            max = Math.max(nums[i], max);
            preGcd[i] = gcd(nums[i], max);
        }
        Arrays.sort(preGcd);
        long sum = 0;
        for(int i = 0; i < n / 2; ++i){
            sum += gcd(preGcd[i], preGcd[n - i - 1]);
        }
        return sum;
    }

    private int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}