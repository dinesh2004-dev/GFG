class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        int n = arr.length;
        int right = 0,left = 0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int count = 0;
        
        while(right < n){
            mpp.put(arr[right],mpp.getOrDefault(arr[right],0)+1);
            
            while(mpp.size() > k){
                mpp.put(arr[left],mpp.get(arr[left]) - 1);
                if(mpp.get(arr[left]) == 0){
                    mpp.remove(arr[left]);
                }
                left++;
            }
            if(mpp.size() <= k){
                count += (right - left + 1);
            }
            right++;
        }
        return count;
    }
}
