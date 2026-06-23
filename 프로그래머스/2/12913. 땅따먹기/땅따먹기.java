import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 0; i < land.length - 1; i++) {
            for (int j = 0; j < 4; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    max = Math.max(max, land[i][k]);
                }
                
                land[i + 1][j] += max;
            }
        }
        
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, land[land.length - 1][j]);
        }

        return answer;
    }
}