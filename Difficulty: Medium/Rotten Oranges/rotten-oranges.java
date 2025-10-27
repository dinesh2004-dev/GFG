class Solution {
     private static int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public boolean isSafe(int nRow,int nCol,int m,int n){

        if(nRow < 0 || nRow >= m){

            return false;
        }
        if(nCol < 0 || nCol >= n){

            return false;
        }

        return true;
    }
    public int orangesRot(int[][] mat) {
        // code here
         int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        int total = 0;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(mat[i][j] != 0){

                    total++;
                }

                if(mat[i][j] == 2){

                    q.add(new int[]{i,j});
                }
            }
        }

        int count = 0;
        int time = 0;

        while(!q.isEmpty()){

            int k = q.size();
            count += k;

            while(k-- > 0){
                int[] cell = q.poll();

                int row = cell[0];
                int col = cell[1];

                for(int[] dir : directions){

                    int nRow = row + dir[0];
                    int nCol = col + dir[1];

                    if(isSafe(nRow,nCol,m,n) && mat[nRow][nCol] == 1){

                        mat[nRow][nCol] = 2;
                        q.add(new int[]{nRow,nCol});
                    }
                }
            }

            if(!q.isEmpty()){
                time++;
            }

        }

        if(total == count){

            return time;
        }

        return -1;
        
    }
}