import java.util.*;

class Solution {
    
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    
    public int solution(String dirs) {
        int answer = 0;
        
        int nx = 5;
        int ny = 5;
        Set<String> set = new HashSet<>();
        
        for (char c : dirs.toCharArray()) {
            int i = getDir(c);
            
            int bx = nx;
            int by = ny;
            nx += dx[i];
            ny += dy[i];
            
            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) {
                nx = bx;
                ny = by;
                continue;
            }
            set.add("" + bx + by + nx + ny);
            set.add("" + nx + ny + bx + by);
        }
        
        return set.size() / 2;
    }
    
    private static int getDir(char c) {
        if (c == 'U') return 0;
        if (c == 'R') return 1;
        if (c == 'D') return 2;
        return 3;
    }
}