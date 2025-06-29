class Solution {
    public boolean check(int mid,int[] arr,int k){
        int n = arr.length;
        int sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > mid){
                return false;
            }
            
            sum += arr[i];
            if(sum > mid){
                sum = arr[i];
                count++;
            }
        }
        count++;
        return count <= k;
    }
    public int splitArray(int[] arr, int k) {
        // code here
        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();
        int ans = 0;
        
        while(start <= end){
            int mid = (start + end) / 2;
            
            if(check(mid,arr,k)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
};