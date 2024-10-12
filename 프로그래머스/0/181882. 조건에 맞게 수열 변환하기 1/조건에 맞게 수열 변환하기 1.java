import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        return IntStream.of(arr)
                .map(i -> i >= 50 && i % 2 == 0 ? i / 2 : i < 50 && i % 2 == 1 ? i * 2 : i)
                .toArray();
    }
}