import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        List<Map<Character, Integer>> list = new ArrayList<>();
        for (int i = 0; i < keymap.length; i++) {
            char[] chars = keymap[i].toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < chars.length; j++) {
                if (!map.containsKey(chars[j])) map.put(chars[j], j + 1);
            }
            list.add(map);
        }
        
        for (int i = 0; i < targets.length; i++) {
            char[] chars = targets[i].toCharArray();
            for (int j = 0; j < targets[i].length(); j++) {
                int min = Integer.MAX_VALUE;
                boolean check = false;
                for (var m : list) {
                    if (!m.containsKey(chars[j])) {
                        continue;
                    }
                    check = true;
                    int value = m.get(chars[j]);
                    if (value < min) min = value;
                }
                if (!check) {
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += min;    
                }
            }
        }
        
        return answer;
    }
}