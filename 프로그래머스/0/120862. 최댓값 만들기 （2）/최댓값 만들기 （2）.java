import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int[] arr = Arrays.stream(numbers).sorted().toArray();
        return Math.max(arr[0] * arr[1], arr[numbers.length - 2] * arr[numbers.length - 1]);
    }
}