class Solution {
    
    private static int[][] directions = {
        {-2,1},
        {-2,-1},
        {-1,-2},
        {-1,2},
        {1,-2},
        {1,2},
        {2,-1},
        {2,1}
        
    };
                                         
    public boolean isSafe(int i,int j,int step,int n,
            ArrayList<ArrayList<Integer>> board){
        
        return (i >= 0 && i < n && j >= 0 && j < n && board.get(i).get(j) == 
            -1);
    }
    
    public boolean knightTourUntil(int i,int j,int step,int n,
        ArrayList<ArrayList<Integer>> board){
            
            if(step == n * n){
                
                return true;
            }
            
            for(int[] dir : directions){
                
               int x = i + dir[0];
               int y = j + dir[1];
                
                if(isSafe(x,y,step + 1,n,board)){
                    
                    board.get(x).set(y,step);
                    
                    if(knightTourUntil(x,y,step + 1,n,board)){
                        
                        return true;
                    }
                    
                     board.get(x).set(y,-1);
                }
            }
            
            return false;
        }
    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        // code here
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            
            ArrayList<Integer> row = new ArrayList<>();
            
            for(int j = 0; j < n; j++){
                
                row.add(-1);
            }
            
            board.add(row);
        }
        
        board.get(0).set(0,0);
        
        if(knightTourUntil(0,0,1,n,board)){
            
            return board;
        }
        
        return new ArrayList<ArrayList<Integer>>();
    }
}