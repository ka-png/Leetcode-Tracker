class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;
        int[][] memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(grid, m - 1, n - 1, memo);
    }

    private int dfs(int[][] grid, int i, int j, int[][] memo) {
        if (i < 0 || j < 0 || grid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (memo[i][j] != -1) return memo[i][j];
        return memo[i][j] = dfs(grid, i - 1, j, memo) + dfs(grid, i, j - 1, memo);
    }
}   