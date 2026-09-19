import java.util.*;

class Solution {
    
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {0, -1, 0, 1, 1, 1, 0, -1, -1};
    
    public int solution(int[][] board) {
        int answer = 0;
        
        int n = board.length, m = board[0].length;
        boolean[][] notSafe = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) continue;
                
                for (int dir = 0; dir < 9; dir++) {
                    int nx = i + dx[dir];    
                    int ny = j + dy[dir];
                    
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    notSafe[nx][ny] = true;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!notSafe[i][j]) answer++;
            }
        }
        
        
        return answer;
    }
}