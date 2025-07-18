class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        int left = 0,right = 0;
        int maxLen = -1;
        
        HashMap<Character,Integer> mpp = new HashMap<>();
        
        while(right < n){
            mpp.put(s.charAt(right),mpp.getOrDefault(s.charAt(right),0) + 1);
            if(mpp.size() > k){
                mpp.put(s.charAt(left),mpp.get(s.charAt(left)) - 1);
                if(mpp.get(s.charAt(left)) == 0){
                    mpp.remove(s.charAt(left));
                }
                left++;
            }
            if(mpp.size() == k){
                maxLen = Math.max(maxLen,right - left + 1);
            }
            right++;
        }
        return maxLen;
    }
}