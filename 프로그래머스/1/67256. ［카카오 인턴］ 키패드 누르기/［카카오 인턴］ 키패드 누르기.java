import java.util.*;

class Solution {
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] map = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {-1, 0, -2}
    };
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int leftCur = -1, rightCur = -2;
        for (var i : numbers) {
            char c;
            if (i == 1 || i == 4 || i == 7) {
                leftCur = i;
                c = 'L';
            } else if (i == 3 || i == 6 || i == 9) {
                rightCur = i;
                c = 'R';
            } else {
                int left = this.getCloser(leftCur, i);
                int right = this.getCloser(rightCur, i);
                if (left > right) {
                    rightCur = i;
                    c = 'R';
                } else if (left < right) {
                    leftCur = i;
                    c = 'L';
                } else {
                    if (hand.equals("left")) {
                        leftCur = i;
                        c = 'L';
                    } else {
                        rightCur = i;
                        c = 'R';
                    }
                }
            }
            answer += c;
        }
        
        return answer;
    }
    
    private int getCloser(int current, int target) {
        for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 3; j++) {
                 if (map[i][j] == current) {
                     return this.bfs(i, j, target);
                 }
             }
        }
        return -1;
    }
    
    private int bfs(int x, int y, int target) {
        Queue<Element> q = new LinkedList<>();
        q.offer(new Element(x, y, 0));
        
        boolean[][] v = new boolean[4][3];
        
        while(!q.isEmpty()) {
            Element cur = q.poll();
            int curLevel = cur.level;
            if (map[cur.xy[0]][cur.xy[1]] == target) {
                return curLevel;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.xy[0] + dx[i];
                int ny = cur.xy[1] + dy[i];
                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 3 && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new Element(nx, ny, curLevel + 1));
                }
            }
        }
        return -1;
    }
    
    static class Element {
        int[] xy = new int[2];
        int level;
        
        public Element(int x, int y, int level) {
            this.xy[0] = x;
            this.xy[1] = y;
            this.level = level;
        }
    }
}

/**
1 -2
1 3


0 0 / 0 1 / 0 2
1 0 / 1 1 / 1 2
2 0 / 2 1 / 2 2
- - / 3 1 / - -
**/