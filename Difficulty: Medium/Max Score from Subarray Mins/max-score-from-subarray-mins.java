class Solution {
    public int maxSum(int arr[]) {
        // code here
        int n = arr.length;
        int score = arr[0] + arr[1];
        
        for(int i = 1; i < n - 1; i++){
            score = Math.max(score,arr[i] + arr[i + 1]);
        }
        return score;
    }
}