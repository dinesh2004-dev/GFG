class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        int n = arr.length;
        int ele1 = 0,cnt1 = 0,ele2 = 0,cnt2 = 0;
        for(int i = 0; i < n; i++){
            if(cnt1 == 0 && arr[i] != ele2){
                cnt1 = 1;
                ele1 = arr[i];
            }
            else if(cnt2 == 0 && arr[i] != ele1){
                cnt2 = 1;
                ele2 = arr[i];
            }
            else if(arr[i] == ele1){
                cnt1++;
            }
            else if(arr[i] == ele2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;cnt2 = 0;
        
        for(int ele : arr){
            if(ele == ele1){
                cnt1++;
            }
            else if(ele == ele2){
                cnt2++;
            }
        }
        int oneThird = n / 3;
        ArrayList<Integer> ans = new ArrayList<>();
        if(cnt1 > oneThird){
            ans.add(ele1);
        }
        if(cnt2 > oneThird){
            ans.add(ele2);
        }
        Collections.sort(ans);
        return ans;
        
    }
}