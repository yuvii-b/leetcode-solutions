class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, total = m * n;
        k %= total;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; ++i){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < n; ++j) row.add(0);
            ans.add(row);
        }
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int oldIdx = i * n + j;
                int newIdx = (oldIdx + k) % total;
                ans.get(newIdx / n).set(newIdx % n, grid[i][j]);
            }
        }
        return ans;
    }
}