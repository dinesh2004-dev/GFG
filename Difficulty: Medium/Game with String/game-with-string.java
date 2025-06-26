class Solution {
    public int minValue(String s, int k) {
        // code here
            int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
      
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
      
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }
        
        
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                int mostFrequent = maxHeap.poll();
                
                if (mostFrequent > 1) {
                    maxHeap.offer(mostFrequent - 1);
                }
            }
        }
        
        
        int result = 0;
        while (!maxHeap.isEmpty()) {
            int f = maxHeap.poll();
            result += f * f;
        }
        
        return result;
    }
}