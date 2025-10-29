class Solution {
    public boolean dfs(int node,int color,List<List<Integer>> adj,int[] colors){
        
        colors[node] = color;
        
        for(int neighbour : adj.get(node)){
            
            
            if(colors[neighbour] == -1){
                int nextColor = (color == 1) ? 0 : 1;
                if(!dfs(neighbour,nextColor,adj,colors)){
                    
                    return false;
                }
            }
            else if(colors[node] == colors[neighbour]){
                
                return false;
            }
        }
        return true;
    }
    public List<List<Integer>> constructAdj(int V,int[][] edges){
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        
        int[] colors = new int[V];
        
        Arrays.fill(colors,-1);
        
        List<List<Integer>> adj = constructAdj(V,edges);
        
        for(int i = 0; i < V; i++){
            
            if(colors[i] == -1){
                
                if(!dfs(i,1,adj,colors)){
                    
                    return false;
                }
            }
        }
        
        return true;
    }
}