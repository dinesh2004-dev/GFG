class Solution {
    public void reverse(int[] arr){
        int i = 0,j = arr.length - 1;
        
        while(i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        reverse(a);
        reverse(b);
        
        int n = a.length;
        
        ArrayList<Integer> res = new ArrayList<>();
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[0] - x[0]);
        
        HashSet<String> set = new HashSet<>();
        pq.add(new int[]{a[0] + b[0],0,0});
        set.add("0#0");
        
        while(res.size() < k && !pq.isEmpty()){
            int[] top = pq.poll();
            int curr = top[0],i = top[1],j = top[2];
            
            res.add(curr);
            if(i + 1 < n && !set.contains((i + 1)+"#"+j)){
                
                pq.add(new int[]{a[i + 1] + b[j],i + 1,j});
                set.add((i + 1)+"#"+j);
            }
            if(j + 1 < n && !set.contains(i+"#"+(j + 1))){
                
                pq.add(new int[]{a[i] + b[j + 1],i,j + 1});
                set.add((i+"#"+(j + 1)));
            }
        }
        return res;
    }
}