class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        int n = 9;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(board[i][j] == '.'){
                    for(char num = '1'; num <= '9'; ++num){
                        if(isPossible(board, i, j, num)){
                            board[i][j] = num;
                            if(solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPossible(char[][] board, int i, int j, char num){
        int startRow = (i / 3) * 3, startCol = (j / 3) * 3;
        for(int k = 0; k < 9; ++k){
            if(board[i][k] == num) return false;
            if(board[k][j] == num) return false;
            if(board[startRow + (k / 3)][startCol + (k % 3)] == num) return false;
        }
        return true;
    }
}