import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int[] answer = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
                answer[i] = -1;
            } else {
                int idx = map.get(chars[i]);
                answer[i] = i - idx;
                map.put(chars[i], i);
            }
        }
        
        
        return answer;
    }
}