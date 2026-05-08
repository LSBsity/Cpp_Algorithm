import java.util.*;

class Solution {
    public int solution(int k, int[] tangerines) {
        int answer = 0;
        
        Map<Integer, Integer> count = new HashMap<>();
        for (int tangerine : tangerines) {
            count.merge(tangerine, 1, Integer::sum);
        }
        
        List<Integer> list = new ArrayList<>(count.keySet());
        list.sort((a, b) -> count.get(b) - count.get(a));
        
        for (int i : list) {
            k -= count.get(i);
            answer++;
            
            if (k <= 0) break;
        }
        
        return answer;
    }
}