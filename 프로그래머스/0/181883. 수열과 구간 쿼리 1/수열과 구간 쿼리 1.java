import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        Arrays.stream(queries)
                .forEach(query -> IntStream.rangeClosed(query[0], query[1])
                        .forEach(j -> arr[j]++)
                );
        return arr;
    }
}