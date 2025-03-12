import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int idx = 0;
        for (String[] photo : photos) {
            answer[idx++] = Arrays.stream(photo)
                .mapToInt(str -> map.getOrDefault(str, 0))
                .sum();
        }
        
        return answer;
    }
}