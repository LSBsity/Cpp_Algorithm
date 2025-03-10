import java.util.*;

class Solution {

    public int solution(int k, int[] tangerines) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int tangerine : tangerines) {
            map.put(tangerine, map.getOrDefault(tangerine, 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o2, o1) -> map.get(o1).compareTo(map.get(o2)));

        int answer = 0;
        for (Integer key : keySet) {
            Integer value = map.get(key);
            k -= value;
            answer++;

            if (k <= 0) break;
        }

        return answer;
    }

}