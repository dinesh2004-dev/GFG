class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
        // code here
        
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        
       int minMoves = 0;
        
        for(int i = 0; i < passengers.length; i++){
            
            minMoves += Math.abs(passengers[i] - chairs[i]);
        }
        
        return minMoves;
    }
}
