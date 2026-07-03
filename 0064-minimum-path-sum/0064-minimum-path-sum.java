class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; ++i){
            Arrays.fill(dp[i], -1);
        }
        return solve(grid, dp, 0, 0);
    }

    private int solve(int[][] grid, int[][] dp, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i == m - 1 && j == n - 1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        if(i == m - 1) return dp[i][j] = grid[i][j] + solve(grid, dp, i, j + 1);
        if(j == n - 1) return dp[i][j] = grid[i][j] + solve(grid, dp, i + 1, j);
        return dp[i][j] = grid[i][j] + Math.min(solve(grid, dp, i + 1, j), solve(grid, dp, i, j + 1)); 
    }
}