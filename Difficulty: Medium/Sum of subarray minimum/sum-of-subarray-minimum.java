class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            int mini = Integer.MAX_VALUE;
            for(int j = i; j < arr.length; j++){
                mini = Math.min(mini,arr[j]);
                 sum += mini;
            }
           
        }
        return sum;
    }
}
