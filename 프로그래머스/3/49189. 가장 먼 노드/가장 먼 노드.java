import java.util.*;

class Solution {
    
    static List<List<Node>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int u = e[0];
            int v = e[1];
            
            graph.get(u).add(new Node(v, 1));
            graph.get(v).add(new Node(u, 1));
        }
        
        return go(n);
    }
    
    private int go(int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        pq.offer(new Node(1, 0));
        int maxDist = -1;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.w > dist[cur.v]) continue;
            
            for (Node next : graph.get(cur.v)) {
                
                int newCost = dist[cur.v] + next.w;
                if (newCost < dist[next.v]) {
                    dist[next.v] = newCost;
                    maxDist = Math.max(maxDist, dist[next.v]);
                    pq.offer(new Node(next.v, newCost));
                }
            }
        }
    
        int cnt = 0;
        for (int d : dist) {
            if (d == maxDist) cnt++;
        }
        
        return cnt;
    }
    
    public static class Node implements Comparable<Node> {
        int v;
        int w;
        
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        } 
    }
}