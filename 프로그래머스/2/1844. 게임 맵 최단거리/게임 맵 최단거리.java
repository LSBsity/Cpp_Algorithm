import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    static class Node {
        int x;
        int y;
        int dist;
        
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int dist = node.dist;
            
            if (x == n - 1 && y == m - 1) return dist;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + this.dx[i];
                int ny = y + this.dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, dist + 1));
                }
            } 
        }
        
        
        return -1;
    }
}