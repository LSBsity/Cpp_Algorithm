import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class Solution {
    public long solution(long n) {
        return Long.parseLong(
                Arrays.stream(String.valueOf(n).split(""))
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.joining())
        );
    }
}