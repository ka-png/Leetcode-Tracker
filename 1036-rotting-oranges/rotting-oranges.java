class Solution {
    private static int[] x = {1, -1, 0, 0};
    private static int[] y = {0, 0, 1, -1};

    private boolean valid(int x, int y, int n, int m, int grid[][]) {
        if(x>=0 && x<n && y>=0 && y<m)
            return true;
        return false;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int freshOrgs = 0;
        int rottenOrgs = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    rottenOrgs++;
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1)
                    freshOrgs++;
            }
        }

        int time = 0;
        while(!q.isEmpty() && freshOrgs > 0) {
            int size = q.size();

            while(size > 0) {
                int[] node = q.poll();
                for(int var=0; var<4; var++) {
                    int row = node[0] + x[var];
                    int col = node[1] + y[var];
                    if(valid(row, col, n, m, grid) && grid[row][col]==1) {
                        q.add(new int[]{row,col});
                        grid[row][col] = -2;
                        freshOrgs--;
                    }
                }
                size--;
            }
            time++;
        }
        int ans = freshOrgs > 0 ? -1 : time;
        return ans;
    }
}