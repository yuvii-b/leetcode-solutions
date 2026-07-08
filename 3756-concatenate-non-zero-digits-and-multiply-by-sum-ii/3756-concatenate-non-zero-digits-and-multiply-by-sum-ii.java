class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        long MOD = (long)1e9 + 7;
        int n = s.length();

        // precomputation arrays
        long[] preSum = new long[n + 1];
        long[] preProduct = new long[n + 1];
        int[] nonZeroCnt = new int[n + 1];
        long[] power10 = new long[n + 1];
        power10[0] = 1;

        for(int i = 0; i < n; ++i){
            power10[i + 1] = (power10[i] * 10) % MOD;
            int digit = s.charAt(i) - '0';
            preSum[i + 1] = preSum[i] + digit;
            if(digit == 0){
                preProduct[i + 1] = preProduct[i];
                nonZeroCnt[i + 1] = nonZeroCnt[i];
            }else{
                preProduct[i + 1] = (preProduct[i] * 10 + digit) % MOD;
                nonZeroCnt[i + 1] = nonZeroCnt[i] + 1;
            }
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; ++i){
            int l = queries[i][0], r = queries[i][1];
            long sum = preSum[r + 1] - preSum[l];
            int count = nonZeroCnt[r + 1] - nonZeroCnt[l];
            long subtract = (preProduct[l] * power10[count]) % MOD;
            long x = (preProduct[r + 1] - subtract + MOD) % MOD;

            res[i] = (int)((x * sum) % MOD);
        }
        return res;
    }
}