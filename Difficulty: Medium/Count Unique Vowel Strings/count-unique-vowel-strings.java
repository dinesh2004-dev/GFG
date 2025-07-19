class Solution {
    public int fact(int num){
        int fact = 1;
        for(int i = 1; i <= num; i++){
            fact *= i;
        }
        return fact;
    }
    public int vowelCount(String s) {
        // code here
        if(s.length() == 1){
            return 0;
        }
        Map<Character,Integer> mpp = new HashMap<>();
        String vowels = "aeiou";
        for(char ch : s.toCharArray()){
            if(vowels.indexOf(ch) != -1){
                mpp.put(ch,mpp.getOrDefault(ch,0)+1);
            }
        }
        int noOfVowels = mpp.size();
        if(noOfVowels == 0){
            return 0;
        }
        int res = fact(noOfVowels);
        for(Map.Entry<Character,Integer> entry : mpp.entrySet()){
            if(entry.getValue() > 1){
                res *= entry.getValue();
            }
        }
        return res;
    }
}