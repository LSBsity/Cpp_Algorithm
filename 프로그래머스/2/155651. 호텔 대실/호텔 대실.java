import java.util.*;

class Solution {
    
    int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    public int solution(String[][] book_time) {
        List<int[]> events = new ArrayList<>();
        
        for (String[] booking : book_time) {
            int checkIn = timeToMinutes(booking[0]);
            int checkOut = timeToMinutes(booking[1]) + 10; 
            
            events.add(new int[]{checkIn, 1});   
            events.add(new int[]{checkOut, -1});
        }
        
        events.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; 
            }
            return a[0] - b[0];
        });
        
        int currentRooms = 0;
        int maxRooms = 0;
        
        for (int[] event : events) {
            currentRooms += event[1];
            maxRooms = Math.max(maxRooms, currentRooms);
        }
        
        return maxRooms;
    }
}