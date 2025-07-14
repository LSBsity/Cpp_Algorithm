import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            nodes.get(edge[1]).add(edge[0]);
            nodes.get(edge[0]).add(edge[1]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int node : nodes.get(current)) {
                if (dist[node] == -1) {
                    q.offer(node);
                    dist[node] = dist[current] + 1;    
                }
            }
        }
        
        int max = Arrays.stream(dist).max().getAsInt();
        return (int)Arrays.stream(dist).filter(i -> i == max).count();
    }
}