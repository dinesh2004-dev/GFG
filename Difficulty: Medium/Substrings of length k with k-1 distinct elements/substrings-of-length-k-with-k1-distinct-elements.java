class Solution {
    public int substrCount(String s, int k) {
        // code here
        int n = s.length();
        int distinctCount = 0,ans = 0;
        int[] hash = new int[26];
        int left = 0,right = 0;
        
        while(right < n){
            int addIndex = s.charAt(right) - 'a';
            hash[addIndex]++;
            if(hash[addIndex] == 1){
                distinctCount++;
            }
            
            while((right - left + 1) > k){
                int removeIdx = s.charAt(left) - 'a';
                hash[removeIdx]--;
                if(hash[removeIdx] == 0){
                    distinctCount--;
                }
                left++;
            }
            
            if((right - left + 1) == k && distinctCount == k - 1){
                ans++;
            }
            right++;
        }
        return ans;
    }
}