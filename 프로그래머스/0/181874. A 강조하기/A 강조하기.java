import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {
        return Arrays.stream(myString.split(""))
                .map(s -> Objects.equals(s, "a") || Objects.equals(s, "A") ? "A" : s.toLowerCase())
                .collect(Collectors.joining());
    }
}