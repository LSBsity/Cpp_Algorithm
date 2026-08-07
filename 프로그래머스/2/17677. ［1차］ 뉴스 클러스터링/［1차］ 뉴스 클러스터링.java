import java.util.*;

class Solution {
    
    static Map<String, Integer> map1 = new HashMap<>();
    static Map<String, Integer> map2 = new HashMap<>();
    
    public int solution(String str1, String str2) {
        int answer = 0;
        
        String strA = str1.toUpperCase();
        String strB = str2.toUpperCase();
        
        for (int i = 1; i < strA.length(); i++) {
            String str = strA.substring(i - 1, i + 1);
            if (Character.isLetter(str.charAt(0)) && Character.isLetter(str.charAt(1))) {
                map1.put(str, map1.getOrDefault(str, 0) + 1);    
            }
        }
        for (int i = 1; i < strB.length(); i++) {
            String str = strB.substring(i - 1, i + 1);
            if (Character.isLetter(str.charAt(0)) && Character.isLetter(str.charAt(1))) {
                map2.put(str, map2.getOrDefault(str, 0) + 1);    
            }
        }
        
        int total1 = map1.values().stream().mapToInt(Integer::intValue).sum();
        int total2 = map2.values().stream().mapToInt(Integer::intValue).sum();

        int inter = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            inter += Math.min(entry.getValue(), map2.getOrDefault(entry.getKey(), 0));
        }
        
        int union = total1 + total2 - inter;
        return union == 0 ? 65536 : (int) ((long) inter * 65536 / union);
    }
}