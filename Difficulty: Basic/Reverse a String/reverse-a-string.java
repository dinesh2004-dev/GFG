// User function Template for Java

class Solution {
    public static String reverseString(String s) {
        // code here
        int i = 0,j = s.length() - 1;
        char[] ch = s.toCharArray();
        
        while(i < j){
            
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] =  temp;
            i++;
            j--;
            
        }
        return new String(ch);
    }
}