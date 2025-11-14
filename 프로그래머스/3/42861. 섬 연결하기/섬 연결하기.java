import java.util.*;

class Solution {
    
    static List<Node> list;
    static int[] parent;
    
    private int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        
        return parent[a] = find(parent[a]);
    }
    
    private boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        
        if (aa == bb) return false;
        
        if (aa > bb) {
            parent[aa] = bb;
        } else {
            parent[bb] = aa;
        }
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        list = new ArrayList<>();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int[] cost : costs) {
            list.add(new Node(cost[0], cost[1], cost[2]));
        }
        
        list.sort((o1, o2) -> Integer.compare(o1.w, o2.w));
        
        int answer = 0;
        for (var node : list) {
            int u = node.u;
            int v = node.v;
            int w = node.w;
            
            if (union(u, v)) {
                answer += w;
            }
        }
        
        return answer;
    }
    
    static class Node {
        int u;
        int v;
        int w;
        
        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}