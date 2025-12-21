class Solution {
    public int findLowerBound(int[] arr,int low,int high,int key){
        
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            
            if(arr[mid] >= key){
                
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public int findUpperBound(int[] arr,int low,int high,int key){
        
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            
            if(arr[mid] > key){
                
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return low;
    }
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        // code here
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int n = arr.length;
        
        for(int[] query : queries){
            
            int l = query[0];
            int r = query[1];
            int key = query[2];
            
            int lowerBound = findLowerBound(arr,l,r,key);
            int higherBound = findUpperBound(arr,l,r,key);
            
            res.add(higherBound - lowerBound);
        }
        
        return res;
    }
}