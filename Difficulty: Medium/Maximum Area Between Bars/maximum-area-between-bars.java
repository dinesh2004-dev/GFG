class Solution {
    public int maxArea(List<Integer> height) {
        // code here
        
        int n = height.size();
        
        int left = 0,right = n - 1;
        
        int maxArea = Integer.MIN_VALUE;
        
        while(left < right){
            
            int lBar = height.get(left);
            int rBar = height.get(right);
            
            if(lBar > rBar){
                
                int area = rBar * (right - left - 1);
                
                maxArea = Math.max(maxArea,area);
                
                right--;
            }
            else{
                
                int area = lBar * (right - left - 1);
                
                maxArea = Math.max(maxArea,area);
                
                left++;
                
            }
        }
        
        return maxArea;
    }
}