import java.util.*;

class Solution {
    
    static char[][] map;
    
    static int[][] coords = {{0, 0}, {0, 0}, {0, 0}}; 
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int row, col; 
    
    public int solution(String[] maps) {
        int answer = 0;
        
        row = maps.length; col = maps[0].length();
        map = new char[row][col];
        
        
        for (int i = 0; i < row; i++) {
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = chars[j];
                
                if (map[i][j] == 'S') {
                    coords[0][0] = i; coords[0][1] = j;
                } else if (map[i][j] == 'L') {
                    coords[1][0] = i; coords[1][1] = j;
                } else if (map[i][j] == 'E') {
                    coords[2][0] = i; coords[2][1] = j;
                }
            }
        }
        
        
        int a = go(coords[0][0], coords[0][1], coords[1][0], coords[1][1]);
        if (a == -1) return -1;
        
        int b = go(coords[1][0], coords[1][1], coords[2][0], coords[2][1]);
        if (b == -1) return -1;
        
        return a + b;
    }
    
    private int go(int a, int b, int c, int d) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        
        q.offer(new int[] {a, b, 0});
        visited[a][b] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == c && cur[1] == d) {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'X') continue;
                
                q.offer(new int[] {nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
            
        }
        
        return -1;
    }
}