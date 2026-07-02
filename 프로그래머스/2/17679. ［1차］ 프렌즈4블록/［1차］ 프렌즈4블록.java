import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][n];
        int idx = 0;
        for (String str : board) {
            map[idx++] = str.toCharArray();
        } 

        while (true) {
            boolean[][] v = new boolean[m][n];
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != ' ' && check(i, j, map)) {
                        v[i][j] = v[i][j + 1] = v[i + 1][j] = v[i + 1][j + 1] = true; 
                    }
                }
            }    
            
            boolean check = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (v[i][j]) {
                        map[i][j] = ' ';
                        answer++;
                        check = false;
                    }
                }
            } 
            if (check) break;
            
            for (int j = 0; j < n; j++) {
                for (int i = m - 2; i >= 0; i--) {
                    if (map[i][j] != ' ' && map[i + 1][j] == ' ') {
                        char c = map[i][j];
                        int k = i;
                        
                        while (k + 1 < m && map[k + 1][j] == ' ') k++;
                        
                        map[i][j] = ' ';
                        map[k][j] = c;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private static boolean check(int i, int j, char[][] map) {
        if (map[i][j] == map[i][j + 1] &&
            map[i][j] == map[i + 1][j] &&
            map[i][j] == map[i + 1][j + 1]) {
            return true;
        }
        
        return false;
    }
}