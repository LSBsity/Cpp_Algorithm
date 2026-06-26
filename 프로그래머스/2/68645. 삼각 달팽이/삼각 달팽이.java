import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, -1};
    static int[] dy = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        
        int maxSize = (n + 1) * n / 2;
        int[] answer = new int[maxSize];
        
        int x = 0, y = 0, dir = 0, cnt = 2;
        map[0][0] = 1;
        
        while (cnt <= maxSize) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                dir = (dir + 1) % 3;
                continue;
            }
            if (map[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                continue;
            }
            
            map[nx][ny] = cnt++;
            x = nx;
            y = ny;
        }
        
        for (int i = 0, idx = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[idx++] = map[i][j];
            }
        }
        
        return answer;
    }
}