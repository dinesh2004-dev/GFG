class Solution {
    private static boolean myComparator(String x,String y){
        
        String xy = x + y;
        String yx = y + x;
        
        return xy.compareTo(yx) > 0;
    }
    public String findLargest(int[] arr) {
        // code here
        
        List<String> numbers = new ArrayList<>();
        
        for(int ele : arr){
            
            numbers.add(Integer.toString(ele));
        }
        
        Collections.sort(numbers,(x,y) -> myComparator(x,y) ? -1 : 1);
        
        if(numbers.get(0).equals("0")){
            
            return "0";
        }
        
        StringBuilder str = new StringBuilder();
        
        for(String num : numbers){
            
            str.append(num);
        }
        
        return str.toString();
    }
}