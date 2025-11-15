class Solution {
    public void sortInWave(int arr[]) {
        // code here
        
        int n = arr.length;
        
        for(int i = 2; i <= n; i+=2){
            
            int temp = arr[i - 1];
            arr[i - 1] = arr[i - 2];
            arr[i - 2] = temp;
        }
    }
}
