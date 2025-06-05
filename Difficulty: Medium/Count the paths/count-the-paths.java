class Solution {
    public int dfs(int start,int dest,ArrayList<ArrayList<Integer>> adj,
    int[] memo){
        if(start == dest){
            return 1;
        }
        
        if(memo[start] != -1){
            return memo[start];
        }
        int count = 0;
        
        for(int v : adj.get(start)){
            
            count += dfs(v,dest,adj,memo);
        }
        
        memo[start] = count;
        
        return count;
    }
    
    public ArrayList<ArrayList<Integer>> convertAdj(int[][] edges,int v){
        
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();
        
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : edges){
            
            adj.get(arr[0]).add(arr[1]);
        }
        
        return adj;
    }
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        
        ArrayList<ArrayList<Integer>> adj = convertAdj(edges,V);
        
        int[] memo = new int[V];
        Arrays.fill(memo,-1);
        
        return dfs(src,dest,adj,memo);
    }
}