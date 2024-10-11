import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int k) {
        IntStream stream = Arrays.stream(arr);
        return k % 2 == 0 ? stream.map(i -> i + k).toArray() : stream.map(i -> i * k).toArray();
    }
}