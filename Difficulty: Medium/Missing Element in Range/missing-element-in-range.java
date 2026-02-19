class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        
        Set<Integer> set = new HashSet<>();
        
        for(int ele : arr){
            
            set.add(ele);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = low; i <= high; i++){
            
            if(!set.contains(i)){
                
                res.add(i);
            }
        }
        
        return res;
        
    }
}