class Solution {
    
   
    
    public void backtrack(int i,int j,int[][] maze,ArrayList<String> ans,
    String temp){
        
        if(i < 0 || i >= maze.length || j < 0 || j >= maze[0].length
            || maze[i][j] == 0){
                
                return;
            }
        
        if(i == maze.length - 1 && j == maze[0].length - 1){
            
            ans.add(temp.toString());
            return;
        }
        
        maze[i][j] = 0;
        
        
        
        
        backtrack(i - 1,j,maze,ans,temp+"U");
        backtrack(i,j + 1,maze,ans,temp+"R");
        backtrack(i,j - 1,maze,ans,temp+"L");
        backtrack(i + 1,j,maze,ans,temp+"D");
        
        
        maze[i][j] = 1;
        
        
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        
        ArrayList<String> ans = new ArrayList<>();
        
        backtrack(0,0,maze,ans,"");
        
        Collections.sort(ans);
        
        return ans;
    }
}