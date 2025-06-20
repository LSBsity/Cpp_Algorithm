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
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        
        for (int[] node : road) {
            int u = node[0];
            int v = node[1];
            int w = node[2];
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        this.go(1);
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
    
    private void go(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        q.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            
            if (!visited[current.v]) {
                visited[current.v] = true;
            }
            
            for (Node next : graph[current.v]) {
                if (!visited[next.v] && dist[next.v] > next.w + current.w) {
                    dist[next.v] = next.w + current.w;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
    }
}