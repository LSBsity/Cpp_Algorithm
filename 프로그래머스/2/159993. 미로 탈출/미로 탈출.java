import java.util.*;

class Solution {
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[] starts = new int[2];
    int[][] coords = new int[2][2];
    
    public int bfs(int[][] map, int[] start, int[] dest) {
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] visited = new boolean[map.length][map[0].length];
        q.offer(new int[]{start[0], start[1], 0});
        visited[q.peek()[0]][q.peek()[1]] = true;
        
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int level = q.peek()[2];
            q.poll();
            
            if (x == dest[0] && y == dest[1]) {
                return level;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || visited[nx][ny] || map[nx][ny] == 1) continue;
                q.offer(new int[]{nx, ny, level + 1});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    starts[0] = i; starts[1] = j;
                } else if (c == 'L') {
                    coords[0][0] = i; coords[0][1] = j;
                } else if (c == 'E') {
                    coords[1][0] = i; coords[1][1] = j;
                } else if (c == 'X') {
                    map[i][j] = 1;
                    continue;
                } 
                map[i][j] = 0;
            }
        }
        int a = bfs(map, new int[]{starts[0], starts[1]}, new int[]{coords[0][0], coords[0][1]});
        int b = bfs(map, new int[]{coords[0][0], coords[0][1]}, new int[]{coords[1][0], coords[1][1]});

        return a == -1 || b == -1 ? -1 : a + b;
    }
}