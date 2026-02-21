class Solution {
    public int hIndex(int[] citations) {
        // code here
        
        int n = citations.length;
        int i = 0;
        
        Arrays.sort(citations);
        while(i < n && citations[n - i - 1] > i){
            
            i++;
        }
        
        return i;
    }
}