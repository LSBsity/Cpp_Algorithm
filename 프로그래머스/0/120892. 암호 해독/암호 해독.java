import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(String cipher, int code) {
        return IntStream.rangeClosed(1, cipher.length())
                .filter(i -> i % code == 0)
                .mapToObj(i -> String.valueOf(cipher.charAt(i - 1)))
                .collect(Collectors.joining());
    }
}