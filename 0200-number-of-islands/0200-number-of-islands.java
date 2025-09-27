class Solution {
    private void bfs(char[][] grid, int i, int j){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int m = grid.length;
        int n = grid[0].length;

        grid[i][j] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            for(int k = 0; k < 4; ++k){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1'){
                    grid[nx][ny] = '0';
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == '1'){
                    ++count;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
}