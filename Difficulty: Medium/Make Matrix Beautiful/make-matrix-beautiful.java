class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int maxSum = Integer.MIN_VALUE;
        int n = mat.length;
        for(int[] arr : mat){
            int sum = Arrays.stream(arr).sum();
            maxSum = Math.max(sum,maxSum);
        }
        for(int i = 0;i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += mat[j][i];
            }
            maxSum = Math.max(maxSum,sum);
        }
        
        int result = 0;
        for(int arr[] : mat){
            int sum = Arrays.stream(arr).sum();
            result += maxSum - sum;
        }
        return result;
        
    }
}