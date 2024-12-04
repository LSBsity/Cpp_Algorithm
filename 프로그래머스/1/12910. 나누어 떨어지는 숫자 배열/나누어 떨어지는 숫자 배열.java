import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] array = Arrays.stream(arr)
                .filter(i -> i % divisor == 0)
                .sorted()
                .toArray();
        return array.length == 0 ? new int[]{-1} : array;
    }
}