import java.util.stream.IntStream;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.rangeClosed(0, included.length - 1)
                .filter(i -> included[i])
                .map(i -> a + (d * i))
                .sum();
    }
}