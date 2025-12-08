class Solution {
    public void fill(char[][] grid) {
        // Code here
        int x, y, xy[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}, m = grid.length, n = grid[0].length, pair[];
        boolean vis[][] = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 'O' && (i == 0 || j == 0 || i == m-1 || j == n-1)) {
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
                else {
                    vis[i][j] = false;
                }
            }
        }
        while(!queue.isEmpty()) {
            pair = queue.poll();
            for(int i = 0; i < 4; i++) {
                x = pair[0] + xy[i][0];
                y = pair[1] + xy[i][1];
                if(x > -1 && y > -1 && x < m && y < n && vis[x][y] == false && grid[x][y] == 'O') {
                    queue.offer(new int[]{x, y});
                    vis[x][y] = true;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j]) {
                    grid[i][j] = 'X';
                }
            }
        }
    }
}
