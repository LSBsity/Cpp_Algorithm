import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        IntStream stream = Arrays.stream(arr);
        int even = (int) stream.filter(i -> i % 2 == 0).count();
        stream = Arrays.stream(arr);
        int odd = (int) stream.filter(i -> i % 2 == 1).count();

        int[] ints = new int[2];
        ints[0] = even;
        ints[1] = odd;
        
        return ints;
    }
}