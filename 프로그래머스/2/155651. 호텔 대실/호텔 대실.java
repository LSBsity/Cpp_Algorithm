import java.util.*;
import java.time.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        LocalTime[][] timeline = new LocalTime[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            for (int j = 0; j < 2; j++) {
                timeline[i][j] = LocalTime.parse(book_time[i][j]);
            }
        }
        Arrays.sort(timeline, (a, b) -> a[0].compareTo(b[0]));
        
        List<List<LocalTime[]>> hotel = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            hotel.add(new ArrayList<>());
        }
        
        for (int i = 0; i < timeline.length; i++) {
            LocalTime[] customer = timeline[i];
            LocalTime customerStartTime = customer[0];

            for (int j = 0; j < hotel.size(); j++) {
                List<LocalTime[]> room = hotel.get(j);
                
                if (room.size() == 0) {
                    room.add(customer);
                    answer++;
                    break;
                }
                
                LocalTime[] lastReservation = room.get(room.size() - 1);
                LocalTime endTime = lastReservation[1].isAfter(LocalTime.of(23, 49))
                                        ? LocalTime.MAX
                                        : lastReservation[1].plusMinutes(10);
                
                if (!endTime.isAfter(customerStartTime)) {
                    room.add(customer);
                    break;
                } 
            }
        }
        
        
        return answer;
    }
}