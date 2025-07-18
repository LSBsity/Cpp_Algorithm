import java.util.*;

class Solution {
    
    boolean[][] visited;
    int[][] map;
    List<Integer> answer = new ArrayList<>();
    int sum = 0;
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
     
    private void go(int i, int j) {
        if (visited[i][j]) return;
        
        visited[i][j] = true;
        sum += map[i][j];
        
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == -1 || visited[nx][ny]) continue;
            this.go(nx, ny);
        }
    }
    
    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = chars[j] == 'X' ? -1 : chars[j] - '0'; 
            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (map[i][j] != -1 && !visited[i][j]) {
                    this.go(i, j);
                    answer.add(sum);
                    sum = 0;
                }
            }
        }
        
        Collections.sort(answer);
        if (answer.size() == 0) return new int[]{-1};
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}