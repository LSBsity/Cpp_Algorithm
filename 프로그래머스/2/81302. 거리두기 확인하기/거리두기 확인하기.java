import java.util.*;

class Solution {
    
    static char[][] map;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};
        
        int idx = 0;
        for (String[] place : places) {
            map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                map[i] = place[i].toCharArray();
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == 'P' && isNotComply(i, j, idx)) {
                        answer[idx] = 0;
                    }
                }
            }
            idx++;
        }
        
        return answer;
    }
    
    private boolean isNotComply(int i, int j, int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        
        q.offer(new int[] {i, j});
        visited[i][j] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            int dist = check(i, j, cur[0], cur[1]);
            
            if (dist >= 3) continue;
            if (dist >= 1 && map[cur[0]][cur[1]] == 'P') return true;
        
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (visited[nx][ny] || map[nx][ny] == 'X') continue;
                
                q.offer(new int[] {nx, ny});   
                visited[nx][ny] = true;
            }
        }
        
        return false;
    }
    
    private int check(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}