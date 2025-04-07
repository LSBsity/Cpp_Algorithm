import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (var str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        } 
        
        for (var str : completion) {
            map.put(str, map.get(str) - 1);
        }
        for (var str : map.keySet()) {
            if (map.get(str) != 0) {
                return str;
            }
        }
        
        return "";
    }
}