import java.util.*;

class Solution {
    
    int[] points = {0, 3, 2, 1, 0, 1, 2, 3};
    String[] types = {"", "RT", "CF", "JM", "AN"};
    
    public String solution(String[] survey, int[] choices) {
        Map<Integer, int[]> map = new TreeMap<>();
        
        for (int i = 0; i < survey.length; i++) {
            char[] type = survey[i].toCharArray();
            int key = type[0] + type[1];
            int[] scores = map.getOrDefault(key, new int[91]);
            
            this.check(type, choices[i], scores);
            map.put(type[0] + type[1], scores);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            String type = types[i];
            int key = type.charAt(0) + type.charAt(1);
            
            if (map.containsKey(key)) {
                int[] scores = map.get(key);
                int first = scores[type.charAt(0)];
                int second = scores[type.charAt(1)];
                if (first > second) {
                    sb.append(type.charAt(0));
                } else if (first < second) {
                    sb.append(type.charAt(1));
                } else {
                    char max = (char)Math.min(type.charAt(0), type.charAt(1));
                    sb.append(max);
                }
            } else {
                char max = (char)Math.min(type.charAt(0), type.charAt(1));
                sb.append(max);
            }
        }
        
        return sb.toString();
    }
    
    private void check(char[] type, int choice, int[] scores) {
        int point = points[choice];
        if (choice < 4) {
            scores[type[0]] += point;
        } else if (choice > 4) {
            scores[type[1]] += point;
        }
    }
}