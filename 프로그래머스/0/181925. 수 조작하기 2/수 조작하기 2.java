import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(int[] arr) {
        return IntStream.range(1, arr.length)
                .mapToObj(i -> switch (arr[i] - arr[i - 1]) {
                    case 1 -> "w";
                    case -1 -> "s";
                    case 10 -> "d";
                    case -10 -> "a";
                    default -> "";
                }).collect(Collectors.joining());
    }
}