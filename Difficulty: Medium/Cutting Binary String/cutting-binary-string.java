class Solution {
    public boolean check(int num){
        if(num == 0){
            return false;
        }
        while(num % 5 == 0){
            num = num / 5;
        }
        return num == 1;
    }
    public int solve(String s,int ind){
        int n = s.length();
        if(ind >= n){
            return 0;
        }
        int ans = n + 1;
        int num = 0;
        for(int i = ind; i < n; i++){
            num = num * 2 + ((s.charAt(i) == '1') ? 1 : 0 );
           
           if(s.charAt(ind) != '0' && check(num)){
               int next = solve(s,i + 1);
               if(next != n + 1){
                   ans = Math.min(ans,next + 1);
               }
           }
            
        }
        return ans;
    }
    public int cuts(String s) {
        // code here
        int n = s.length();
        int ans = solve(s,0);
        if(ans == n + 1){
            return -1;
        }
        return ans;
    }
}
