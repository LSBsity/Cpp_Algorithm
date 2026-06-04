import java.util.*;

class Solution {
    
    
    
    public int solution(int n, int[][] results) {
        int cnt = 0;
        List<Integer>[] win = new ArrayList[n + 1];
        List<Integer>[] lose = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        
        for (int[] result : results) {
            int w = result[0];
            int l = result[1];
            
            win[w].add(l);
            lose[l].add(w);
        }
        
        for (int i = 1; i <= n; i++) {
            int winCnt = go(win, i);
            int loseCnt = go(lose, i);
            
            if (winCnt + loseCnt == n - 1) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private static int go(List<Integer>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}