class Solution {
    public boolean canMake(int[] ranks,int n,int timeAlloted){
        
        int cnt = 0;
        
        for(int i = 0; i < ranks.length; i++){
            
            int timeSpent = 0;
            int r = ranks[i];
            
            
            while(r + timeSpent <= timeAlloted){
                
                cnt++;
                
                timeSpent += r;
                r += ranks[i];
            }
        }
        
        return cnt >= n;
    }
    public int minTime(int[] ranks, int n) {
        // code here
        
        int len = ranks.length;
        int minRank = ranks[0];
        
        for(int i = 1; i < len; i++){
            
           minRank = Math.min(minRank,ranks[i]);
        }
        
        int low = 0,high = minRank * n * (n + 1) / 2;
        int ans = high;
        
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            
            if(canMake(ranks,n,mid)){
                
                ans = mid;
                high = mid - 1;
            }
            else{
                
                low = mid + 1;
            }
        }
        
        return ans;
    }
}