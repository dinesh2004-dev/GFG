class Solution {
    public static String caseSort(String s) {
        // code here
        int n = s.length();
        char[] upper = new char[n];
        char[] lower = new char[n];
        
        int lowerIdx = 0,upperIdx = 0;
        
        for(char c : s.toCharArray()){
            
            if(Character.isLowerCase(c)){
                lower[lowerIdx++] = c;
            }
            else{
                upper[upperIdx++] = c;
            }
        }
        
        Arrays.sort(upper,0,upperIdx);
        Arrays.sort(lower,0,lowerIdx);
        
        lowerIdx = 0;
        upperIdx = 0;
        
        StringBuilder result = new StringBuilder(s);
        
        for(int i = 0; i < n; i++){
            if(Character.isLowerCase(s.charAt(i))){
                result.setCharAt(i,lower[lowerIdx++]);
            }
            else{
                result.setCharAt(i,upper[upperIdx++]);
            }
        }
        return result.toString();
    }
}