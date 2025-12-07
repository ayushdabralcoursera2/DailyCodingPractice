class Solution {
    public int orangesRot(int[][] mat) {
        // code here
        int m = mat.length, n = mat[0].length, fresh = 0, c = 0, c1 = 0, t = 0, node[], xs[] = {-1, 0, 0, 1}, ys[] = {0, -1, 1, 0};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    c++;
                }
                else if(mat[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while(!queue.isEmpty()) {
            while(c > 0) {
                node = queue.poll();
                for(int i = 0; i < 4; i++) {
                    if(node[0] + xs[i] > -1 && node[1] + ys[i] > -1 && node[0] + xs[i] < m && node[1] + ys[i] < n && mat[node[0] + xs[i]][node[1] + ys[i]] == 1) {
                        queue.offer(new int[]{node[0] + xs[i],node[1] + ys[i]});
                        mat[node[0] + xs[i]][node[1] + ys[i]] = 2;
                        c1++;
                        fresh--;
                    }
                }
                c--;
            }
            t += c1 > 0? 1:0;
            c = c1;
            c1 = 0;
        }
        return fresh == 0? t : -1;
    }
}