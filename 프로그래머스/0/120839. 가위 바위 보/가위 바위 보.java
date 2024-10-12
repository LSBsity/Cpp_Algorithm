import java.util.stream.Collectors;

class Solution {
    public String solution(String rsp) {
        return rsp.chars()
                .mapToObj(i -> switch ((char) i) {
                    case '2' -> '0';
                    case '0' -> '5';
                    case '5' -> '2';
                    default -> '1';
                })
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}