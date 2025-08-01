class Solution {
    public int countBalanced(String[] arr) {
        // code here
       Map<Integer,Integer> mpp = new HashMap<>();
       mpp.put(0,1);
       String vowels = "aeiou";
       int prefixSum = 0;
       int res = 0;
       for(String str : arr){
           
           int score = 0;
           for(char ch : str.toCharArray()){
               if(vowels.indexOf(ch) != -1){
                   score++;
               }
               else{
                   score--;
               }
           }
           prefixSum += score;
           res += mpp.getOrDefault(prefixSum,0);
           mpp.put(prefixSum,mpp.getOrDefault(prefixSum,0)+1);
           
       }
       return res;
       
    }
}