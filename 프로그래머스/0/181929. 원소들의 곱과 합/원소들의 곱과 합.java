import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list)
                .sum();
        return sum * sum > Arrays.stream(num_list)
                .reduce(1, (left, right) -> left * right) ? 1 : 0;
    }
}