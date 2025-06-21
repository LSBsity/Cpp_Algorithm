import java.util.*;

class Solution {
    
    int[] dist;
    boolean[] visited;
    List<Node>[] graph;
    
    static class Node {
        int v;
        int w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    
    
    public int solution(int n, int[][] road, int k) {
        int answer = 0;
        
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        
        for (int[] i : road) {
            int u = i[0];
            int v = i[1];
            int w = i[2];
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        
        this.dijkstra(1);
        
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= k) answer++;
        }
        
        return answer;
    }
    
    private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            visited[current.v] = true;
            
            for (Node next : graph[current.v]) {
                if (!visited[next.v] && dist[next.v] > current.w + next.w) {
                    dist[next.v] = current.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}