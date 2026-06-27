class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;
        for(int i = 0; i < n; ++i){
            sum += mat[i][i];
            sum += mat[i][n - 1 - i];
        }
        return (n % 2 == 0) ? sum : sum - mat[n / 2][n / 2];
    }
}