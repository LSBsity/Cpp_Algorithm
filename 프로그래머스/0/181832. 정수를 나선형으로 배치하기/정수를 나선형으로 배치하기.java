import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int[][] solution(int n) {
        int[][] answer =  new int[n][n];
        int val = 1;
        
        int dir = 0;
        int x = 0, y = 0;
        
        answer[x][y] = val++;
        
        int max = n * n;
        
        while (val <= max) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || answer[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
            
            answer[nx][ny] = val++;
        }
        
        return answer;
    }
}