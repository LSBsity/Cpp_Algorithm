import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int[][] map;    

    static int[][] coords = {{0, 0}, {0, 0}};
    
    public int solution(String[] board) {
        int answer = 0;
        
        map = new int[board.length][board[0].length()];

        for (int i = 0; i < map.length; i++) {
            String str = board[i];
            for (int j = 0; j < map[0].length; j++) {
                char c = str.charAt(j);
                if (c == 'D') {
                    map[i][j] = 1;
                } else if (c == 'G') {
                    map[i][j] = 2;
                    coords[1][0] = i;
                    coords[1][1] = j;
                } else if (c == 'R') {
                    coords[0][0] = i;
                    coords[0][1] = j;
                }
            }
        }
        
        answer = go();
        
        return answer;
    }
    
    private static int go() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        
        q.offer(new int[] {coords[0][0], coords[0][1], 0});
        visited[coords[0][0]][coords[0][1]] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == coords[1][0] && cur[1] == coords[1][1]) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int pos = 0;
                int nx = cur[0];
                int ny = cur[1];
                
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    
                    if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || 
                        map[nx][ny] == 1) {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                
                if (!visited[nx][ny]) {
                    q.offer(new int[] {nx, ny, cur[2] + 1});    
                    visited[nx][ny] = true;
                }
            }
        }
                    
        return -1;
    } 
}