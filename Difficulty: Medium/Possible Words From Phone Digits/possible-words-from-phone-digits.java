class Solution {
    
    public String getString(int n){
        switch(n){
            case 1:
                return "";
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                return "";
        }
        
    }
    
    public void solve(int[] arr,ArrayList<String> res,int ind,String str){
        
        if(ind == arr.length){
            
            res.add(str);
            return;
        }
        
        String s = getString(arr[ind]);
        
        if(s.equals("")){
            solve(arr,res,ind + 1,str);
        }
        for(int i = 0; i < s.length(); i++){
            
            solve(arr,res,ind + 1,str + s.charAt(i));
        }
    }
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        
        ArrayList<String> res = new ArrayList<>();
        
        solve(arr,res,0,"");
        
        return res;
    }
}