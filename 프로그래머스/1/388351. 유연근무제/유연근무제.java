import java.util.*;

class Solution {
    
    static int[][] holydays = new int[][] {
        {5, 6},
        {4, 5},
        {3, 4},
        {2, 3},
        {1, 2},
        {0, 1},
        {0, 6}
    };
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int count = 0;
            
            int hour = schedules[i] / 100;
            int minutes = schedules[i] % 100;
            minutes += 10;
            if (minutes >= 60) {
                hour++;
                minutes %= 60;
            }
            int limitTime = hour * 100 + minutes;
            
            for (int j = 0; j < 7; j++) {
                if (j != holydays[startday - 1][0] && j != holydays[startday - 1][1] && timelogs[i][j] <= limitTime) {
                    count++;
                }
            }
            
            if (count == 5) {
                answer++;
            }
        }
        
        return answer;
    }
}