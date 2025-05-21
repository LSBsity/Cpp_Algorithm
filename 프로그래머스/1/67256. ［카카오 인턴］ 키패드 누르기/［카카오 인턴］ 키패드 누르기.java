import java.util.*;

class Solution {
    
    int[][] map = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {10, 0, 12}
    };
    int[][] coord = {
        {3, 1},
        {0, 0},
        {0, 1},
        {0, 2},
        {1, 0},
        {1, 1},
        {1, 2},
        {2, 0},
        {2, 1},
        {2, 2},
        {3, 0},
        {3, 1},
        {3, 2}
    };
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int left = 10;
        int right = 12;
        for (var i : numbers) {
            if (i % 3 == 1) {
                sb.append('L');
                left = i;
            } else if (i != 0 && i % 3 == 0) {
                sb.append('R');
                right = i;
            } else {
                int leftDist = this.go(left, i);
                int rightDist = this.go(right, i);
                char dir = ' ';
                if (leftDist > rightDist) {
                    right = i;
                    dir = 'R';
                } else if (leftDist < rightDist) {
                    left = i;
                    dir = 'L';
                } else {
                    if (hand.equals("right")) {
                        right = i;
                        dir = 'R';
                    } else if (hand.equals("left")) {
                        left = i;
                        dir = 'L';
                    }
                }
                sb.append(dir);
            }
        }
        
        return sb.toString();
    }
    
    private int go(int current, int target) {
        boolean[][] v = new boolean[4][3];
        int[] xy = coord[current];
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{xy[0], xy[1], 0});
        v[xy[0]][xy[1]] = true;
        
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (map[cur[0]][cur[1]] == target) {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 3 && !v[nx][ny]) {
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                    v[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}
