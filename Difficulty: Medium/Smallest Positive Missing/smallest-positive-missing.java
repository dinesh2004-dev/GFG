class Solution {
    public int missingNumber(int[] arr) {
        // code here
        int n = arr.length;
        if(n == 1){
            if(arr[0] <= 0){
                return 1;
            }
        }
        Arrays.sort(arr);
        int i = 0;
        for(i = 0; i < n; i++){
            if(arr[i] >= 0){
                break;
            }
        }
        
        while(i < n && arr[i] == 0){
                i++;
        }
        
            
        
        if(i >=n || arr[i] != 1){
            return 1;
        }
        for(int j = i; j < n - 1; j++){
            if(arr[j] == arr[j + 1]){
                continue;
            }
            if(arr[j] + 1 != arr[j + 1]){
                return arr[j] + 1;
            }
        }
        return arr[n - 1] + 1;
    }
}
