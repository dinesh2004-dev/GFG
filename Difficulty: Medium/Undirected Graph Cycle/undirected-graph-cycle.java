class Solution {
    public boolean dfs(int node,List<Integer>[] adj,boolean[] visited,int prev){
        
        visited[node] = true;
        
        for(int neighbours : adj[node]){
            
            if(!visited[neighbours] ){
                
                if(dfs(neighbours,adj,visited,node)){
                    
                    return true;
                }
            }
            else if(neighbours != prev){
                
                return true;
            }
        }
        
        return false;
    }
    @SuppressWarnings("unchecked")
    static  List<Integer>[] constructadj(int V, int [][] edges){
        
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        return adj;
    } 
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] visited = new boolean[V];
        
        List<Integer> [] adj = constructadj(V,edges);
        
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        for(int i = 0; i < V; i++){
            
            if(!visited[i]){
                if(dfs(i,adj,visited,-1)){
                    
                    return true;
                }
            }
        }
        
        return false;
    }
}