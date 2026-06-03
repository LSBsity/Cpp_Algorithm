import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    
    public int solution(int n, int[][] edges) {
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        return go(1);
    }
    
    
    private static int go(int start) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        
        visited[start] = true;
        q.offer(new int[] {start, 1});
        list.add(new int[] {start, 1});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            max = Math.max(max, cur[1]);  
            
            for (int next : graph[cur[0]]) {
                if (visited[next]) continue;
                
                visited[next] = true;
                q.offer(new int[] {next, cur[1] + 1});
                list.add(new int[] {next, cur[1] + 1});

            }
            
        }
        int cnt = 0;
        for (int[] i : list) {
            if (i[1] == max) {
                cnt++;
            }
        }
        
        return cnt;
    }
}