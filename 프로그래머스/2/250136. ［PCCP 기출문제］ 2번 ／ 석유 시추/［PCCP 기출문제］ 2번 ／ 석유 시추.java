import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int num = 1;
    static int[][] landNum;
    public int solution(int[][] land) {
        int answer = 0;
        
        boolean[][] visited = new boolean[land.length][land[0].length];
        landNum = new int[land.length][land[0].length];
        
        for (int j = 0; j < land[0].length; j++) {
            int sum = 0;
            
            Set<Integer> landNumSet = new HashSet<>();
            for (int i = 0; i < land.length; i++) {
                
                if (land[i][j] == 1 && !visited[i][j]) {
                    sum += go(i, j, land, visited);
                } else if (land[i][j] >= 1 && !landNumSet.contains(landNum[i][j])) {
                    sum += land[i][j];
                }
                landNumSet.add(landNum[i][j]);    
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    public int go(int i, int j, int[][] land, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q.offer(new int[]{i, j});
        q2.offer(new int[]{i, j});
        visited[i][j] = true;
        
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= visited.length || ny >= visited[0].length) continue;
                if (visited[nx][ny] || land[nx][ny] == 0) continue;
                
                q.offer(new int[] {nx, ny});
                q2.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }
        
        while (!q2.isEmpty()) {
            int[] cur = q2.poll();
            land[cur[0]][cur[1]] = cnt;
            landNum[cur[0]][cur[1]] = num;
        }
        num++;
        
        return cnt;
    }
}