class Solution {
    public boolean canAchieveMinHeight(int[] arr,int k,int w,int target){
        int[] heights = arr.clone();
        int dayUsed = 0;
        
        for(int i = 0; i < heights.length; i++){
            if(heights[i] < target){
                int deficit = target - heights[i];
                dayUsed += deficit;
            
                if(dayUsed > k){
                    return false;
                }
                for (int j = i; j < Math.min(i + w, heights.length); j++) {
                        heights[j] += deficit;
                }
            }
        }
        return true;
        
    }
    public int maxMinHeight(int[] arr, int k, int w) {
        // code here
        int min = Arrays.stream(arr).min().getAsInt();
        int low = min,high = min + k;
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(canAchieveMinHeight(arr,k,w,mid)){
                low = mid + 1;
                ans = mid;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}