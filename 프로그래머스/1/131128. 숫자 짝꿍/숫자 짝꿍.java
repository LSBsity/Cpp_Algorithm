import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        
        for (int i = 0; i < X.length(); i++) {
            int value = X.charAt(i) - '0';
            map1.put(value, map1.getOrDefault(value, 0) + 1);
        }
        
        for (int i = 0; i < Y.length(); i++) {
            int value = Y.charAt(i) - '0';
            map2.put(value, map2.getOrDefault(value, 0) + 1);
        }
        
        for (var i : map1.entrySet()) {
            int key = i.getKey();
            if (map2.containsKey(key)) {
                int val = key;
                for (int j = 0; j < Math.min(i.getValue(), map2.get(key)); j++) {
                    sb.append(val);
                }
            }
        }

        boolean check = true;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                check = false;
                break;
            }
        }
        if (check) {
            return sb.length() == 0 ? "-1" : "0";
        }
        
        return sb.reverse().toString();
    }
}