import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i : topping) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : topping) {
            set.add(i);
            map.put(i, map.get(i) - 1);

            if (map.get(i) == 0) {
                map.remove(i);
            }
            if (set.size() == map.size()) {
                answer++;
            }
        }

        return answer;
    }
}