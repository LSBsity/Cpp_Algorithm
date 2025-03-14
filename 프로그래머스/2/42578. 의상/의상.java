import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] arr : clothes) {
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }

        int count = 1;
        for (Integer len : map.values()) {
            count *= len + 1; 
        }
        
        return count - 1;
    }
}