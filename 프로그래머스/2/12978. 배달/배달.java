import java.util.*;

class Solution {
    
    static List<List<Node>> graph = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }
        
        int[] dist = this.dijkstra(N);
        
        for (int d : dist) {
            if (d <= K) answer++;
        }
        
        return answer;
    }
    
    private int[] dijkstra(int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.w > dist[cur.v]) continue;
            
            for (Node next : graph.get(cur.v)) {
                int newCost = dist[cur.v] + next.w;
                if (newCost < dist[next.v]) {
                    dist[next.v] = newCost;
                    pq.offer(new Node(next.v, newCost));
                }
            }
        }
        
        return dist;
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