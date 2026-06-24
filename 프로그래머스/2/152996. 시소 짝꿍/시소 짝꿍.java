import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        
        for (int key : keys) {
            long cnt = map.get(key);
            answer += cnt * (cnt - 1) / 2; // 같은 무게
        }
        
        for (int a : keys) {
            for (int b : keys) {
                if (a >= b) continue;
                if (a * 4 == b * 2 || a * 4 == b * 3 || a * 3 == b * 2) {
                    answer += map.get(a) * map.get(b);
                }
            }
        }
        return answer;
    }
}