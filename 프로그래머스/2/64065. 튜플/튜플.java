import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        Matcher matcher = Pattern.compile("\\d+").matcher(s);

        while (matcher.find()) {
            int parsed = Integer.parseInt(matcher.group());
            map.put(parsed, map.getOrDefault(parsed, 0) + 1);
        }

        return new ArrayList<>(map.keySet())
                .stream()
                .sorted((a, b) -> map.get(b) - map.get(a))
                .mapToInt(i -> i)
                .toArray();
    }
}