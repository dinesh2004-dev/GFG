class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        Integer[] boxedArr = Arrays.stream(b).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr,Collections.reverseOrder());
        b = Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
        int n = a.length;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < b.length; j++){
                if(a[i] >= b[j]){
                    count = b.length - j;
                    break;
                }
            }
            res.add(count);
        }
        return res;
    }
}