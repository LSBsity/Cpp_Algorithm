import java.time.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>(); 
        Map<String, Integer> map = new HashMap<>();
        
        for(String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }
        
        String[] split = today.split("\\.");
        LocalDate now = LocalDate.of(
            Integer.parseInt(split[0]),
            Integer.parseInt(split[1]),
            Integer.parseInt(split[2])
        );

        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split("[. ]");
            
            LocalDate day = LocalDate.of(
                Integer.parseInt(s[0]),
                Integer.parseInt(s[1]),
                Integer.parseInt(s[2])
            );
            
            int termMonth = map.get(s[3]);
            LocalDate expired = day.plusMonths(termMonth);
            
            if (!now.isBefore(expired)) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}