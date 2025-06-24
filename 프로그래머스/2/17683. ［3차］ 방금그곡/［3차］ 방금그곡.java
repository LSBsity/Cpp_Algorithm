import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
    
    private String convert(String before) {
        return before.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a")
            .replaceAll("B#", "b");
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        long maxPlaytime = -1;
        
        String target = this.convert(m);
        
        for (String line : musicinfos) {
            String[] parsed = line.split(",");
            
            LocalTime startTime = LocalTime.parse(parsed[0], fmt);
            LocalTime endTime = LocalTime.parse(parsed[1], fmt);
            long minutes = Duration.between(startTime, endTime).toMinutes();
            
            String codes = this.convert(parsed[3]);
            int length = codes.length();
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < minutes; i++) {
                sb.append(codes.charAt(i % length));
            }
            
            String codeLine = sb.toString();
            if (codeLine.contains(target) && maxPlaytime < minutes) {
                answer = parsed[2];
                maxPlaytime = minutes;
            }
        }
        
        return answer;
    }
}