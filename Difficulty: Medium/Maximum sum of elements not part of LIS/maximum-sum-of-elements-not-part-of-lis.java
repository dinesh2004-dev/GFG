class Solution {
    class LISResult{
        int length;
        int sum;
        public LISResult(int length,int sum){
            this.length = length;
            this.sum = sum;
        }
    }
    public LISResult findSumOfLIS(int[] nums,int ind,int prevInd,LISResult[][] dp){
       if(nums.length == ind){
           return new LISResult(0,0);
       }
       if(dp[ind][prevInd + 1] != null){
           return dp[ind][prevInd + 1];
       }
       LISResult notPick = findSumOfLIS(nums,ind + 1,prevInd,dp);
       LISResult pick = new LISResult(0,0);
       if(prevInd == -1 || nums[ind] > nums[prevInd]){
           LISResult nextResult = findSumOfLIS(nums,ind + 1,ind,dp);
           pick = new LISResult(nextResult.length + 1,nextResult.sum + nums[ind]);
       }
       LISResult res;
       if(pick.length > notPick.length){
           res = pick;
       }
       else if(pick.length < notPick.length){
           res = notPick;
       }
       else{
           res = (pick.sum > notPick.sum) ? notPick : pick;
       }
       return dp[ind][prevInd + 1] = res;
    }
    public int nonLisMaxSum(int[] arr) {
        // code here
        LISResult[][] dp = new LISResult[arr.length][arr.length + 1];
        LISResult sumOfLIS = findSumOfLIS(arr,0,-1,dp);
        int sum = Arrays.stream(arr).sum();
        return  sum - sumOfLIS.sum;
    }
}