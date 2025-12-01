class Solution {
    public double findMedian(int[] arr) {
        // Code here.
        
        Arrays.sort(arr);
        
        int n = arr.length;
        
        double median = arr[n / 2];
        
        if(n % 2 == 0){
            
            median = (double) ((arr[n / 2] + arr[n / 2 - 1]) / 2.0);
        }
        
        return median;
    }
}
