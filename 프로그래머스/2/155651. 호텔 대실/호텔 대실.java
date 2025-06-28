import java.util.*;

class Solution {
    
    private int convert(String time) {
        String[] splited = time.split(":");
        return 60 * Integer.valueOf(splited[0]) + Integer.valueOf(splited[1]);
    }
    
    
    public int solution(String[][] times) {
        List<int[]> list = new ArrayList<>();
        
        for (var time : times) {
            int start = this.convert(time[0]);
            int end = this.convert(time[1]) + 10;
            
            list.add(new int[]{start, 1});
            list.add(new int[]{end, -1});
        }
        
        list.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int currentRooms = 0;
        int answer = 0;
        
        for (var i : list) {
            currentRooms += i[1];
            answer = Math.max(currentRooms, answer);
        }
        
        return answer;
    }
}