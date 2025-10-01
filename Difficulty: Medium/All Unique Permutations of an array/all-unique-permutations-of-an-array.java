class Solution {
    
    public static void solve(int[] arr,ArrayList<Integer> temp,
    ArrayList<ArrayList<Integer>> res,boolean[] visited){
        
        if(temp.size() == arr.length){
            
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            
            if(visited[i] || (i > 0 && arr[i] == arr[i - 1]
            && !visited[i - 1])){
                continue;
            }
            
            visited[i] = true;
            temp.add(arr[i]);
            solve(arr,temp,res,visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        Arrays.sort(arr);
        
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        boolean[] visited = new boolean[arr.length];
        
        solve(arr,temp,res,visited);
        
        return res;
    }
};