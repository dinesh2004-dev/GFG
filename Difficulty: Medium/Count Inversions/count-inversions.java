class Solution {
    private static int merge(int[] arr,int l,int mid,int h){
        
        int i = l,j = mid + 1;
        
        List<Integer> temp = new ArrayList<>();
        
        int cnt = 0;
        
        while(i <= mid && j <= h){
            
            if(arr[i] > arr[j]){
                
                temp.add(arr[j]);
                cnt += (mid - i + 1);
                  j++;
            }
            else{
                
                temp.add(arr[i]);
                i++;
            }
        }
        
        while(i <= mid){
            
            temp.add(arr[i]);
            i++;
        }
        
        while(j <= h){
            
            temp.add(arr[j]);
            j++;
        }
        
        for(i = 0; i < temp.size(); i++){
            
            arr[l + i] = temp.get(i);
        }
        
        return cnt;
    }
    private static int mergeSort(int[] arr,int l,int h){
        
        int count = 0;
        
        if(l >= h){
            
            return 0;
        }
        
        int mid = l + (h - l) / 2;
        
        count += mergeSort(arr,l,mid);
        count += mergeSort(arr,mid + 1,h);
        count += merge(arr,l,mid,h);
        
        return count;
    }
    static int inversionCount(int arr[]) {
        // Code Here
        int n = arr.length;
        
        return mergeSort(arr,0,n - 1);
    }
}