class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;

       int[][] intervals = new int[n][2];

       for(int i = 0; i < n; i++){

            intervals[i][0] = start[i];
            intervals[i][1] = end[i];
       }

       Arrays.sort(intervals,(x,y) -> x[1] - y[1]);

       int cnt = 0;
       int prev = -1;

       for(int i = 0; i < n; i++){

            if(prev == -1){
                cnt++;

                prev = intervals[i][1];
            }

            if(intervals[i][0] > prev){
                cnt++;

                prev = intervals[i][1];
            }
       }
       return cnt;
    }
}
