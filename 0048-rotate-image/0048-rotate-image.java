class Solution {
    // transpose --> for lower triangular (j = 0 -> i), upper triangular (j = i + 1 -> n)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i; ++j){
                swap(matrix, i, j, j, i);
            }
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n / 2; ++j){
                swap(matrix, i, j, i, n - j - 1);
            }
        }
    }

    private void swap(int[][] mat, int r1, int c1, int r2, int c2){
        int temp = mat[r1][c1];
        mat[r1][c1] = mat[r2][c2];
        mat[r2][c2] = temp;
    }
}