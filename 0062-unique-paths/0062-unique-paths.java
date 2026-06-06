class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int R = Math.min(m - 1, n - 1);
        long unique = 1;
        for(int i = 1; i <= R; ++i){
            unique = unique * (N - R + i) / i;
        }
        return (int)unique;
    }
}