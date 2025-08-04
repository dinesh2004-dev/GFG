class Solution {
    public int kadane(int[] arr){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int ele : arr){
            sum += ele;
            if(maxSum < sum){
                maxSum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
            
        }
        return maxSum;
    }
    public int maxRectSum(int mat[][]) {
        // code here
        int rows = mat.length;
        int cols = mat[0].length;
        
        int maxSum = Integer.MIN_VALUE;
        
        int[] temp = new int[rows];
        
        for(int left = 0; left < cols; left++){
            
            Arrays.fill(temp,0);
            
            for(int right = left;right < cols; right++){
                
                for(int row = 0; row < rows; row++){
                    temp[row]  += mat[row][right];
                }
                
                int kadaneSum = kadane(temp);
                
                maxSum = Math.max(kadaneSum,maxSum);
            }
        }
        return maxSum;
    }
};