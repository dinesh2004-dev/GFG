class Solution {
    private int[] findPrefixMax(int[] arr){
        
        int n = arr.length;
        
        int[] prefixMax = new int[n];
        
        prefixMax[0] = arr[0];
        
        for(int i = 1; i < n; i++){
            
            prefixMax[i] = Math.max(arr[i],prefixMax[i - 1]);
        }
        
        return prefixMax;
    }
     private int[] findSuffixMax(int[] arr){
        
        int n = arr.length;
        
        int[] suffixMax = new int[n];
        
        suffixMax[n - 1] = arr[n - 1];
        
        for(int i = n - 2; i >= 0; i--){
            
            suffixMax[i] = Math.max(arr[i],suffixMax[i + 1]);
        }
        
        return suffixMax;
    }
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        
        int[] prefixMax = findPrefixMax(arr);
        int[] suffixMax = findSuffixMax(arr);
        
        int res = 0;
        
        for(int i = 0; i < n; i++){
            
            res = res + (Math.min(prefixMax[i],suffixMax[i]) - arr[i]);
        }
        
        return res;
    }
}
