import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public int[] solution(int num, int total) {
        int sum = -1;
        int idx = -100;
        while (sum != total) {
            sum = 0;
            for (int i = idx; i < idx + num; i++) {
                sum += i;
            }
            idx++;
        }

        return IntStream.range(idx - 1, idx + num - 1).toArray();
    }
}