class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int t = 1, c1, m = grid.length, n = grid[0].length, c = 0, pair[], x, y, xs[] = {-1, 0 , 0, 1}, ys[] = {0, -1, 1, 0};
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            res.add(new ArrayList<Integer>());
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    res.get(i).add(0);
                    queue.add(new int[]{i, j});
                    c++;
                }
                else {
                    res.get(i).add(-1);
                }
            }
        }
        while(!queue.isEmpty()) {
            c1 = 0;
            while(c-- > 0) {
                pair = queue.poll();
                for(int i = 0; i < 4; i++) {
                    x = pair[0] + xs[i];
                    y = pair[1] + ys[i];
                    if(x > -1 && y > -1 && x < m && y < n && res.get(x).get(y) == -1) {
                        queue.offer(new int[]{x, y});
                        res.get(x).set(y, t);
                        c1++;
                    }
                }
            }
            c = c1;
            t++;
        }
        return res;
    }
}