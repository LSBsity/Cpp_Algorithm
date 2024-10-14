import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        return IntStream.of(arr)
                .filter(i -> Arrays.stream(delete_list).noneMatch(j -> j == i))
                .toArray();
    }
}