import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    private final Map<Integer, Character> map = new HashMap<>() {{
        put(0, 'a');
        put(1, 'b');
        put(2, 'c');
        put(3, 'd');
        put(4, 'e');
        put(5, 'f');
        put(6, 'g');
        put(7, 'h');
        put(8, 'i');
        put(9, 'j');
    }};

    public String solution(int age) {
        return String.valueOf(age).chars()
                .mapToObj(i -> String.valueOf(map.get(i - '0')))
                .collect(Collectors.joining());
    }
}