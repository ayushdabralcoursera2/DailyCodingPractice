class Solution {
    
    public boolean helper(ArrayList<ArrayList<Integer>> adj, int node, int vis[]) {
        // System.out.println("HI " + node);
        int n = adj.get(node).size();
        for(int i = 0; i < n; i++) {
            if(vis[adj.get(node).get(i)] == -1) {
                vis[adj.get(node).get(i)] = node;
                if(helper(adj, adj.get(node).get(i), vis)) return true;
            }
            else if(adj.get(node).get(i) != vis[node]) return true;
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int vis[] = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++) {
            adj.add(new ArrayList<Integer>());
            vis[i] = -1; 
        }
        int m = edges.length;
        for(int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0; i < V; i++) {
            if(vis[i] == -1) {
                vis[i] = -2;
                if(helper(adj, i, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}