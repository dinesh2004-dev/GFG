class Solution {
    public void dfs(int node,List<List<Integer>> adj,boolean[] visited
        ,Stack<Integer> st){

            visited[node] = true;

            for(int neighbors : adj.get(node)){

                if(!visited[neighbors]){

                    dfs(neighbors,adj,visited,st);
                }
            }

            st.push(node);
        }
    public List<List<Integer>> constructAdjList(int v,int[][] edges){
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < v; i++){
            
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            
            int t = edge[0];
            int u = edge[1];
            
            adj.get(t).add(u);
        }
        
        return adj;
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        boolean[] visited = new boolean[V];

        Stack<Integer> st = new Stack<>();
        
        List<List<Integer>> adj = constructAdjList(V,edges);

        for(int i = 0; i < V; i++){

            if(!visited[i]){

                dfs(i,adj,visited,st);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(!st.isEmpty()){
            res.add(st.pop());
        }

       

        return res;
    }
}