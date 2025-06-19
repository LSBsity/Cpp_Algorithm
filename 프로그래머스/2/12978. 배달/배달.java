import java.util.*;

class Solution {
    
    static class Node {
        int v;
        int cost;
        
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<Node>[] graph = new ArrayList[N + 1];
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int[] node : road) {
            int u = node[0];
            int v = node[1];
            int w = node[2];
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        
        go(graph, dist, visited, 1);

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;            
        }
        
        return answer;
    }
    
    private int go(List<Node>[] graph, int[] dist, boolean[] visited, int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            
            if (!visited[current.v]) {
                visited[current.v] = true;
            }
            
            for (Node next : graph[current.v]) {
                if (!visited[next.v] && dist[next.v] > current.cost + next.cost) {
                    dist[next.v] = current.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        return -1;
    }
}