import java.util.*;
import java.util.stream.*;

class Solution {
    
    static char[][] map;
    static boolean[][] visited;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        int idx = 0;
        for (String str : maps) {
            map[idx++] = str.toCharArray();
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    answer.add(go(i, j));
                }
            }
        }
        
        if (answer.size() == 0) return new int[] {-1};
        
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }
    
    private int go(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        
        visited[x][y] = true;
        
        int sum = map[x][y] - '0';
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                if (map[nx][ny] == 'X') continue;
                if (visited[nx][ny]) continue;
                
                sum += map[nx][ny] - '0';
                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny});
            }
        }
        
        return sum;
    }
}