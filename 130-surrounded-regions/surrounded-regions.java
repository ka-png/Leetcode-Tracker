class Solution {
    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, 1, -1};   

    private boolean valid(int r, int c, int n, int m) {
        if(r>=0 && r<n && c>=0 && c<m)
            return true;
        return false;
    }

    private void dfs(char[][] board, int r, int c, int n, int m) {
        board[r][c] = '#';
        for(int k=0; k<4; k++) {
            int row = x[k]+r;
            int col = y[k]+c;
            if(valid(row, col, board.length, board[0].length) && board[row][col] == 'O') {
                dfs(board, row, col, board.length, board[0].length);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++)
            if(board[i][0]=='O')
                dfs(board, i, 0, n, m);
        
        for(int i=0; i<n; i++)
            if(board[i][m-1]=='O')
                dfs(board, i, m-1, n, m);
        
        for(int i=0; i<m; i++)
            if(board[0][i]=='O')
                dfs(board, 0, i, n, m);
        for(int i=0; i<m; i++)
            if(board[n-1][i]=='O')
                dfs(board, n-1, i, n, m);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
}