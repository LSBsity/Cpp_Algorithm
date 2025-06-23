import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");

    private String convertMelody(String melody) {
        return melody
                .replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b");
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        long maxTime = -1;
        String target = convertMelody(m); 

        for (String music : musicinfos) {
            String[] line = music.split(",");
            LocalTime startTime = LocalTime.parse(line[0], fmt);
            LocalTime endTime = LocalTime.parse(line[1], fmt);
            long minutes = Duration.between(startTime, endTime).toMinutes();

            String melody = convertMelody(line[3]);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < minutes; i++) {
                sb.append(melody.charAt(i % melody.length()));
            }

            String played = sb.toString();
            if (played.contains(target)) {
                if (minutes > maxTime) {
                    maxTime = minutes;
                    answer = line[2];
                }
            }
        }

        return answer;
    }
}
