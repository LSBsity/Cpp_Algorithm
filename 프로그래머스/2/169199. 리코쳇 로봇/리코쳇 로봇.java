import java.util.*;

class Solution {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    char[][] map;
    int[][] visited;
    int[][] pos = new int[2][2];
    
    public int solution(String[] board) {
        int answer = -1;
        
        map = new char[board.length][board[0].length()];
        visited = new int[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                map[i][j] = chars[j];
                if (map[i][j] == 'R') {
                    pos[0][0] = i;
                    pos[0][1] = j;
                } else if (map[i][j] == 'G') {
                    pos[1][0] = i;
                    pos[1][1] = j;
                }
            }
        }
        
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(pos[0][0], pos[0][1], 0));
        
        while (!q.isEmpty()) {
            Position current = q.poll();
            
            if (current.x == pos[1][0] && current.y == pos[1][1]) {
                answer = current.count;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x;
                int ny = current.y;
                while (true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length()) break;
                    if (map[tx][ty] == 'D') break;
                    nx = tx;
                    ny = ty;
                } 

                if (visited[nx][ny] == 0 || visited[nx][ny] > current.count + 1) {
                    visited[nx][ny] = current.count + 1;
                    q.offer(new Position(nx, ny, current.count + 1));
                }
            }
        }
        
        return answer;
    }
    
    static class Position {
        int x;
        int y;
        int count;
        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}