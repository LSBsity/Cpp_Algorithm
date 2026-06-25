import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
        
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        
        int[][] map = new int[rows][columns];
        for (int i = 0, cnt = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = cnt++;
            }
        }
        
        for (int[] query : queries) {
            answer[idx++] = go(map, query[0], query[1], query[2], query[3]);
        }
        
        return answer;
    }
    
    private static int go(int[][] map, int x1, int x2, int y1, int y2) {
        int row = Math.abs(y2 - x2);
        int col = Math.abs(y1 - x1);
        
        int nx = x1 - 1;
        int ny = x2 - 1;
        int prev = map[nx][ny];
        int min = map[nx][ny];
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < ((i % 2 == 0) ? row : col); j++) {
                nx += dx[i];
                ny += dy[i];
                int temp = map[nx][ny];
                map[nx][ny] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }
        }

        
        return min;
    }
}