import java.util.Arrays;

class Solution {
    private int go(int value) {
        int count = 0;
        while (value != 1) {
            if (value % 2 == 0) value /= 2;
            else value = (value - 1) / 2;
            count++;
        }
        return count;
    }

    public int solution(int[] num_list) {
        return Arrays.stream(num_list)
                .map(this::go)
                .sum();
    }
}