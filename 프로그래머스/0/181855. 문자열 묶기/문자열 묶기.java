import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (String str : strArr) {
            map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
        }

        return map.values()
                .stream()
                .max(Comparator.comparing(i -> i))
                .orElseThrow();
    }
}