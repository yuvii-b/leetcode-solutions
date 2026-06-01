class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            board.add(".".repeat(n));
        }
        solve(0, result, board);
        return result;
    }

    private void solve(int row, List<List<String>> result, List<String> board){
        if(row == board.size()){
            result.add(new ArrayList<>(board));
            return;
        }
        for(int col = 0; col < board.get(0).length(); ++col){
            if(isSafe(board, row, col)){
                char[] rowArr = board.get(row).toCharArray();
                rowArr[col] = 'Q';
                board.set(row, new String(rowArr));
                solve(row + 1, result, board);
                rowArr[col] = '.';
                board.set(row, new String(rowArr));
            }
        }
    }

    private boolean isSafe(List<String> board, int row, int col){
        int r = row, c = col;
        while(r >= 0 && c >= 0){
            if(board.get(r).charAt(c) == 'Q') return false;
            --r;
            --c;
        }
        r = row; c = col;
        while(r >= 0 && c < board.get(0).length()){
            if(board.get(r).charAt(c) == 'Q') return false;
            --r;
            ++c;
        }
        r = row; c = col;
        while(r >= 0){
            if(board.get(r).charAt(c) == 'Q') return false;
            --r;
        }

        return true;
    }
}