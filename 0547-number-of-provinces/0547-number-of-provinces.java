class Solution {
    private void dfs(int node, int[][] adj, boolean[] visited, int v){
        visited[node] = true;
        for(int i = 0; i < v; ++i){
            if(adj[node][i] == 1 && !visited[i]){
                dfs(i, adj, visited, v);
            }
        }
    }

    public int findCircleNum(int[][] adj) {
        int v = adj.length;
        boolean[] visited = new boolean[v];
        int count = 0;
        for(int i = 0; i < v; ++i){
            if(!visited[i]){
                ++count;
                dfs(i, adj, visited, v);
            }
        }
        return count;
    }
}