
class Solution {
    public boolean isSubset(int a[], int b[]) {
        // Your code here
        int len1 = a.length,len2 = b.length;
        
        Map<Integer,Integer> mpp = new HashMap<>();
        
        for(int i = 0; i < a.length; i++){
            
            mpp.put(a[i],mpp.getOrDefault(a[i],0)+1);
        }
        
        for(int i = 0; i < b.length; i++){
            
            if(!mpp.containsKey(b[i])){
                return false;
            }
            
            mpp.put(b[i],mpp.get(b[i]) - 1);
            
            if(mpp.get(b[i]) == 0){
                mpp.remove(b[i]);
            }
        }
        return true;
    }
}
