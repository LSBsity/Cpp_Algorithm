import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for (var i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (var i : arr) {
            set.add(i);
            map.put(i, map.get(i) - 1);
            
            if (map.get(i) == 0) map.remove(i);
            if (set.size() == map.size()) answer++;
        }
        
        
        return answer;
    }
}