class Solution {
    
    public void backtrack(int ind,int n,int k,ArrayList<Integer> temp,
    ArrayList<ArrayList<Integer>> res,int sum){
        
        if(temp.size() == k && sum == n){
            
            res.add(new ArrayList<>(temp));
            return;
        }
        if(ind >= 10 || temp.size() > k || sum > n){
            
            return;
        }
        
        
        backtrack(ind + 1,n,k,temp,res,sum);
        
        temp.add(ind);
        sum += ind;
        backtrack(ind + 1,n,k,temp,res,sum);
        sum -= ind;
        temp.remove(temp.size() - 1);
    }
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        backtrack(1,n,k,temp,res,0);
        
        return res;
    }
}