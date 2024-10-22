import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        if (numbers.length == 2) return numbers[0] * numbers[1];
        int[] arr = Arrays.stream(numbers).sorted().toArray();
        int i = arr[0] * arr[1];
        int j = arr[numbers.length - 2] * arr[numbers.length - 1];
        return Math.max(i, j);
    }
}