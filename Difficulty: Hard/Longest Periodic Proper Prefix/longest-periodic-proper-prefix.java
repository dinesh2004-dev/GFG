class Solution {
    public int[] computeZarray(String s){

        int[] z = new int[s.length()];

        int l = 0,r = 0;

        for(int i = 1; i < s.length(); i++){

            if(i > r){

                while(i + z[i] < s.length() && s.charAt(i + z[i]) == s.charAt(z[i])){

                    z[i]++;
                }
            }
            else{

                if(i + z[i - l] <= r){

                    z[i] = z[i - l];
                }
                else{

                    z[i] = r - i + 1;

                    while(i + z[i] < s.length() && s.charAt(i + z[i]) == s.charAt(z[i])){

                    z[i]++;
                }
                }
            }

            l = i;

            r = i + z[i] - 1;
        }
        return z;
    }
    int getLongestPrefix(String s) {
        // code here
        int n = s.length();
        int[] z = computeZarray(s);

        
        for (int i = n - 1 ; i > 0; i--) {
            if (z[i] == n - i) {
                
                return i;
            }
        }
        return -1;
        
    }
}