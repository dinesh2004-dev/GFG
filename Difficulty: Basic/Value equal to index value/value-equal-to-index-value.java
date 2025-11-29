// User function Template for Java

class Solution {
    public List<Integer> valueEqualToIndex(List<Integer> nums) {
        // code here
        List<Integer> res = new ArrayList<>();
        
        int n = nums.size();
        
        for(int i = 0; i < n; i++){
            
            if(i + 1 == nums.get(i)){
                
                res.add(nums.get(i));
            }
        }
        
        return res;
    }
}