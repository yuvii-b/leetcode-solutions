class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; ++i){
            Arrays.fill(board[i], '.');
        }
        boolean[] cols = new boolean[n];
        boolean[] leftDiagonal = new boolean[2 * n - 1]; // '  /  '
        boolean[] rightDiagonal = new boolean[2 * n - 1]; // '  \  '
        solve(0, board, cols, leftDiagonal, rightDiagonal, result, n);
        return result;
    }

    private void solve(int row, char[][] board, boolean[] cols, boolean[] lDiag, 
                boolean[] rDiag, List<List<String>> result, int n){
        if(row == n){
            result.add(construct(board));
            return;
        }
        for(int col = 0; col < n; ++col){
            int leftDiagIdx = row + col, rightDiagIdx = row - col + (n - 1);
            if(cols[col] || lDiag[leftDiagIdx] || rDiag[rightDiagIdx]) continue;

            board[row][col] = 'Q'; 
            cols[col] = true;
            lDiag[leftDiagIdx] = true;
            rDiag[rightDiagIdx] = true;

            solve(row + 1, board, cols, lDiag, rDiag, result, n);

            board[row][col] = '.'; 
            cols[col] = false;
            lDiag[leftDiagIdx] = false;
            rDiag[rightDiagIdx] = false;
        }
    }

    private List<String> construct(char[][] board){
        List<String> config = new ArrayList<>();
        for(int i = 0; i < board.length; ++i){
            config.add(new String(board[i]));
        }
        return config;
    }
}