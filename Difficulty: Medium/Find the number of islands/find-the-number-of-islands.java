class Solution {
     public void dfs(int r,int c,char[][] grid,boolean[][] visited){

      if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
          || grid[r][c] == 'W' || visited[r][c]){

            return;
          }

          visited[r][c] = true;

          for(int delRow = -1; delRow <= 1; delRow++){

              for(int delCol = -1; delCol <= 1; delCol++){

                  int row = r + delRow;
                  int col = c + delCol;
                  dfs(row,col,grid,visited);
              }
          }

    }
    public int countIslands(char[][] grid) {
        // Code here
        int m = grid.length;
       int n = grid[0].length;

       int noOfIslands = 0;

       boolean[][] visited = new boolean[m][n];

       for(int i = 0; i < m; i++){

          for(int j = 0; j < n; j++){

              if(!visited[i][j] && grid[i][j] == 'L'){

                  dfs(i,j,grid,visited);
                  noOfIslands++;
              }
          }
       }

       return noOfIslands;
    }
}