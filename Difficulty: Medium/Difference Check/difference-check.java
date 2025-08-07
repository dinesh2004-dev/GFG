class Solution {
    public  int toSeconds(String time){
        int hr = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        int sec = Integer.parseInt(time.split(":")[2]);
        
        return 3600 * hr + 60 * min + sec;
    }
    public int minDifference(String[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> seconds = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++){
            seconds.add(toSeconds(arr[i]));
        }
        
        Collections.sort(seconds);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < seconds.size(); i++){
            int diff = seconds.get(i) - seconds.get(i - 1);
            minDiff = Math.min(minDiff,diff);
        }
        
        int roundOff = 86400 - (seconds.get(seconds.size() - 1) - 
                                            seconds.get(0));
        
        minDiff = Math.min(minDiff,roundOff);
        return minDiff;
    }
}
