class Solution {
    
    static char[][] map;
    
    static int[] dx = {-1, 0, 1, 0}; // 북동남서 NESW
    static int[] dy = {0, 1, 0, -1};

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        
        int n = park.length;
        int m = park[0].length();
        map = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            char[] chars = park[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                map[i][j] = chars[j];
                if (map[i][j] == 'S') {
                    answer[0] = i; answer[1] = j;
                } 
            }
        }
        
        for (String route : routes) {
            String[] split = route.split(" ");
            int dir = getDir(split[0].charAt(0));
            int distance = Integer.parseInt(split[1]);
            
            boolean check = true;
            int nx = answer[0], ny = answer[1];
            for (int i = 0; i < distance; i++) {
                nx += dx[dir];
                ny += dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 'X') {
                    check = false;
                    break;
                }
            }
            
            if (check) {
                answer[0] = nx;
                answer[1] = ny;
            }
        }
        
        return answer;
    }
    
    private int getDir(char dir) {
        if (dir == 'N') {
            return 0;
        } else if (dir == 'E') {
            return 1;
        } else if (dir == 'S') {
            return 2;
        }
        return 3;
    }
}