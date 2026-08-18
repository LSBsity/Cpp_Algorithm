import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < timelogs.length; i++) {
            int should = schedules[i] + 10;
            if (should % 100 >= 60) {
                should += 40;
            }
            
            boolean check = true;
            for (int j = 0, day = startday; j < timelogs[i].length; j++, day = (day % 7) + 1) {
                if (day >= 6) continue;
                    
                if (should < timelogs[i][j]) {
                    check = false;
                    break;
                }
            }
            
            if (check) answer++;
        }
        
        return answer;
    }
}