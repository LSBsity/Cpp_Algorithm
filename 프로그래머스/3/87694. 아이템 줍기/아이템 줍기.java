import java.util.*;

class Solution {
    
    static int[][] map = new int[102][102];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        
        for (int[] rec : rectangles) {
            int x1 = rec[0] * 2, y1 = rec[1] * 2;
            int x2 = rec[2] * 2, y2 = rec[3] * 2;
            
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        if (map[x][y] != 2) map[x][y] = 1;
                    } else {
                        map[x][y] = 2;
                    }
                }
            }
        }

        
        return go(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }
    
    private static int go(int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        
        q.offer(new int[]{sx, sy, 1});
        visited[sx][sy] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            
            if (x == ex && y == ey) return dist;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx > 101 || ny > 101) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != 1) continue; 
                
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }
        
        return -1;
    }
}