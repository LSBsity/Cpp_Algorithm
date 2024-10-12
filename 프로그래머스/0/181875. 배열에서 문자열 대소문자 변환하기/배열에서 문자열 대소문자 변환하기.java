import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public String[] solution(String[] arr) {
        AtomicInteger i = new AtomicInteger(0);
        return Arrays.stream(arr)
                .map(s -> i.getAndIncrement() % 2 == 0 ? s.toLowerCase() : s.toUpperCase())
                .toArray(String[]::new);
    }
}