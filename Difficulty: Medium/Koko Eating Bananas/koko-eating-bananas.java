class Solution {
    public boolean check(int[] arr,int k,int mid){
        
        int time = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            time += arr[i]/mid;
            
            if(arr[i] % mid != 0){
                time++;
            }
        }
        return time <= k;
    }
    public int kokoEat(int[] arr, int k) {
        // code here
        int max = Arrays.stream(arr).max().getAsInt();
        
        int low = 1,high = max + 1;
        
        int res = high;
        
        while(low <= high){
            
            int mid = (low + high) / 2;
            
            if(check(arr,k,mid)){
                
                high = mid - 1;
                
                res = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}
