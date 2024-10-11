import java.util.stream.Collectors;
import static java.lang.Character.*;

class Solution {
    public String solution(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .map(c -> isUpperCase(c) ? toLowerCase(c) : toUpperCase(c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}