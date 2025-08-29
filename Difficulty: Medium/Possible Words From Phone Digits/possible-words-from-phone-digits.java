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
    public void solve(int ind,String s,int[] arr,ArrayList<String> res){
        
        if(ind == arr.length){
            res.add(s);
            return;
        }
        
        
        String str = getString(arr[ind]);
        if(str.equals("")){
             solve(ind + 1,s,arr,res);
        }
        
        for(int i = 0; i < str.length(); i++){
            
            solve(ind + 1,s + str.charAt(i),arr,res);
        }
    }
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        
        solve(0,"",arr,res);
        
        return res;
    }
}