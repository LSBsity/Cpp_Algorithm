import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list, int n) {

        return IntStream.concat(
                        IntStream.of(Arrays.copyOfRange(num_list, n, num_list.length)),
                        IntStream.of(Arrays.copyOfRange(num_list, 0, n))
                ).toArray();
    }
}