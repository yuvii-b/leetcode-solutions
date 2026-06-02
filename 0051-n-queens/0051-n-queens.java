class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; ++i){
            Arrays.fill(board[i], '.');
        }
        solve(0, board, result, n);
        return result;
    }

    private void solve(int row, char[][] board, List<List<String>> result, int n){
        if(row == n){
            result.add(construct(board));
            return;
        }

        for(int col = 0; col < n; ++col){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                solve(row + 1, board, result, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board){
        for(int i = 0; i < row; ++i){
            if(board[i][col] == 'Q') return false;
        }

        int r = row, c = col;
        while(r >= 0 && c >= 0){
            if(board[r--][c--] == 'Q') return false;
        }

        r = row; c = col;
        while(r >= 0 && c < board.length){
            if(board[r--][c++] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board){
        List<String> config = new ArrayList<>();
        for(int i = 0; i < board.length; ++i){
            config.add(new String(board[i]));
        }
        return config;
    }
}