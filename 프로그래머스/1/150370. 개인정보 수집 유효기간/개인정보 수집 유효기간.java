import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        
        String[] todays = today.split("\\.");
        LocalDate now = LocalDate.of(Integer.parseInt(todays[0]), Integer.parseInt(todays[1]), Integer.parseInt(todays[2]));
        
        for (var term : terms) {
            String[] p = term.split(" ");
            m.put(p[0], Integer.parseInt(p[1]));
        }

        int count = 1;
        for (var privacy : privacies) {
            String[] p = privacy.split(" ");
            String[] d = p[0].split("\\.");
            String t = p[1];
            LocalDate termDay = LocalDate.of(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
            LocalDate expired = termDay.plusMonths(m.get(t)).minusDays(1);
            if (expired.isBefore(now)) {
                answer.add(count);
            }
            count++;
        }

        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}