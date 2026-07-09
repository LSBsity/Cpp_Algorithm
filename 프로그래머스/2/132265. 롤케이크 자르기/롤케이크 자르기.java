import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = -1;
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for (int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            
            int cnt = map.get(t);
            
            if (cnt > 0) {
                set.add(t);
                if (cnt - 1 == 0) {
                    map.remove(t);
                } else {
                    map.put(t, map.get(t) - 1);
                }
            }
            
            int myCnt = map.size();
            int broCnt = set.size();
            
            if (myCnt == broCnt) answer++;
        }
        
        return answer + 1;
    }
}