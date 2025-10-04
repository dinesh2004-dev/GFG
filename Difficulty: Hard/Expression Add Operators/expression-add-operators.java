class Solution {
    
    public void solve(int ind,String s,int target,ArrayList<String> ans,
    String expr,int val,int last){
        
        if(s.length() == ind){
            
            if(target == val){
                
                ans.add(expr);
            }
            return;
        }
        
        for(int i = ind; i < s.length(); i++){
            
            if(i != ind && s.charAt(ind) == '0'){
                
                break;
            }
            
            String part = s.substring(ind,i + 1);
            
            int num = Integer.parseInt(part);
            
            if(ind == 0){
                
                solve(i + 1,s,target,ans,part,num,num);
            }
            else{
                
                solve(i + 1,s,target,ans,expr+"+"+part,val + num,num);
                solve(i + 1,s,target,ans,expr+"-"+part,val - num,-num);
                solve(i + 1,s,target,ans,expr+"*"+part,val - last + last * 
                num,last * num);
            }
        }
    }
    
    public ArrayList<String> findExpr(String s, int target) {
        // code here
        
        ArrayList<String> ans = new ArrayList<>();
        
        solve(0,s,target,ans,"",0,0);
        
        return ans;
    }
}