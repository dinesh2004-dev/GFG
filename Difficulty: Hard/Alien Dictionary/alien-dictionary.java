import java.util.*;

class Solution {
    // Topological sort that only considers letters marked present[]
    public List<Integer> topoSort(int V, List<List<Integer>> adj, boolean[] present) {
        int[] indegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (present[i] && indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (present[nei] && indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        return topo;
    }

    public String findOrder(String[] words) {
        int N = words.length;
        // which lowercase letters appear in the dictionary
        boolean[] present = new boolean[26];
        int presentCount = 0;
        for (String s : words) {
            for (char ch : s.toCharArray()) {
                int idx = ch - 'a';
                if (!present[idx]) {
                    present[idx] = true;
                    presentCount++;
                }
            }
        }

        // adjacency for all 26 letters to avoid indexing issues
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());

        // avoid duplicate edges
        boolean[][] added = new boolean[26][26];

        // build graph from adjacent word pairs
        for (int i = 0; i < N - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());

            int j = 0;
            for (; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    int u = c1 - 'a';
                    int v = c2 - 'a';
                    if (!added[u][v]) {
                        adj.get(u).add(v);
                        added[u][v] = true;
                    }
                    break; // only the first different char gives precedence
                }
            }
            // invalid case: s1 is longer and s2 is prefix of s1 -> impossible
            if (j == len && s1.length() > s2.length()) {
                return "";
            }
        }

        List<Integer> topo = topoSort(26, adj, present);

        // if topo doesn't include all present letters, there is a cycle -> invalid
        if (topo.size() < presentCount) return "";

        // build result string from topo order (only present letters are included)
        StringBuilder sb = new StringBuilder();
        for (int node : topo) {
            sb.append((char) ('a' + node));
        }
        return sb.toString();
    }

    // quick main for local testing (optional)
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words1 = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(sol.findOrder(words1)); // example valid order e.g. "bdac"

        String[] words2 = {"caa", "aaa", "aab"};
        System.out.println(sol.findOrder(words2)); // example "cab"

        String[] words3 = {"ab", "cd", "ef", "ad"};
        System.out.println(sol.findOrder(words3)); // ""
    }
}
