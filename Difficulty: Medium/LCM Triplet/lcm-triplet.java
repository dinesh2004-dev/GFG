class Solution {
    int gcd(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    int lcmTriplets(int n) {
        // code here
        if(n < 3){
            return n;
        }
        if(n % 2 != 0){
            return n * (n - 1) * (n - 2);
        }
        if(gcd(n,n - 3) == 1){
            return n * (n - 1) * (n - 3);
        }
        return (n - 1) * (n - 2) * (n - 3);
        
    }
}