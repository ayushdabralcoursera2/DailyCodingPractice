class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int m = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int vis[] = new int[V];
        for(int i = 0; i < V; i++) {
            vis[i] = -1;
        }
        
        for(int i = 0; i < V; i++) {
            if(vis[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                vis[i] = -2;
                while(!queue.isEmpty()) {
                    int parent = queue.poll();
                    for(int child: adj.get(parent)) {
                        if(vis[child] == -1) {
                            queue.offer(child);
                            vis[child] = parent;
                        }
                        else if(child != vis[parent]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
