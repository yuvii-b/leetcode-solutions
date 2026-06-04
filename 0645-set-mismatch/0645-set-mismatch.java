class Solution {
    public int[] findErrorNums(int[] nums) {
        long sum = 0, sumOfN = 0, square = 0, squareOfN = 0, n = nums.length;
        for(int i = 0; i < n; ++i){
            sum += nums[i];
            square += nums[i] * nums[i];
        }
        sumOfN = n * (n + 1) / 2;
        squareOfN = n * (n + 1) * (2 * n + 1) / 6;
        long val1 = sum - sumOfN; // x - y
        long val2 = square - squareOfN; // x^2 - y^2
        val2 /= val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[]{(int)x, (int)y};

    }
}