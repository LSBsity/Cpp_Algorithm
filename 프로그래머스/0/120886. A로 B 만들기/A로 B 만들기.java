import java.util.stream.Collectors;

class Solution {
    public int solution(String before, String after) {
        String bef = before.chars()
                .mapToObj(i -> (" " + i)).sorted()
                .collect(Collectors.joining());

        String aft = after.chars()
                .mapToObj(i -> (" " + i)).sorted()
                .collect(Collectors.joining());

        return bef.equals(aft) ? 1 : 0;
    }
}