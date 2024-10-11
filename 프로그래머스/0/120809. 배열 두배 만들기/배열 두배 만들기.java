import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array) {
        IntStream.range(0, array.length).forEach(i -> array[i] *= 2);
        return array;
    }
}