import java.util.*;

class Solution {
    
    public int solution(int[][] map, int[][] skill) {
        int n = map.length;
        int m = map[0].length;
        
        int[][] diff = new int[n + 1][m + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            int value = (type == 1) ? -degree : degree;
            
            diff[r1][c1] += value;
            diff[r1][c2 + 1] -= value;
            diff[r2 + 1][c1] -= value;
            diff[r2 + 1][c2 + 1] += value;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] += diff[i][j];
                if (map[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}