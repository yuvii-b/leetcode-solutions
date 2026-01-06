class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean[] flags = new boolean[4];
        Arrays.fill(flags, true);
        int n = mat.length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(mat[i][j] != target[i][j]) flags[0] = false;
                if(mat[i][j] != target[j][n - i - 1]) flags[1] = false;
                if(mat[i][j] != target[n - i - 1][n - j - 1]) flags[2] = false;
                if(mat[i][j] != target[n - j - 1][i]) flags[3] = false;
            }
        }
        return flags[0] || flags[1] || flags[2] || flags[3];
    }
}