class Solution {
    static final int MOD = 1_000_000_007;
    long[] fact, invFact;
    
    public int countValidSequences(int n, int k) {
        precompute(n);
        long total = nCr(n - 1, k - 1);
        long odd = 0;
        if(((n - k) & 1) == 0){
            int sum = (n - k) / 2;
            odd = nCr(sum + k - 1, k - 1);
        }
        return (int)((total - odd + MOD) % MOD);
    }

    private void precompute(int max){
        fact = new long[max + 1];
        invFact = new long[max + 1];
        fact[0] = 1;
        for(int i = 1; i <= max; ++i) fact[i] = fact[i - 1] * i % MOD;
        invFact[max] = power(fact[max], MOD - 2);
        for(int i = max - 1; i >= 0; --i) invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    private long nCr(int n, int r){
        if(r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    private long power(long a, long b){
        long res = 1;
        while(b > 0){
            if((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}