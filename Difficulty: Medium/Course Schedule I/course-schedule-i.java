class Solution {
    public boolean dfs(int node,List<List<Integer>> adj,boolean[] visited,
        boolean[] pathVisited){

            visited[node] = true;
            pathVisited[node] = true;

            for(int neighbors : adj.get(node)){

                if(pathVisited[neighbors]){

                    return true;
                }
                else if(!visited[neighbors]){

                    if(dfs(neighbors,adj,visited,pathVisited)){

                        return true;
                    }
                }
            }

            pathVisited[node] = false;
            return false;
        }
    
    public List<List<Integer>> constructAdjacencyList(int n,int[][] arr){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){

            adj.add(new ArrayList<>());
        }

        for(int[] edge : arr){

            adj.get(edge[0]).add(edge[1]);
        }

        return adj;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>> adj = constructAdjacencyList(n,prerequisites);

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        for(int i = 0; i < n; i++){

            if(!visited[i]){

                if(dfs(i,adj,visited,pathVisited)){

                    return false;
                }
            }
        }

        return true;

    }
}