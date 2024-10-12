import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        IntStream stream = IntStream.rangeClosed(0, n);
        return n % 2 == 1 ? stream.filter(i -> i % 2 == 1).sum() :
                stream.filter(i -> i % 2 == 0).map(i -> i * i).sum();
    }
}