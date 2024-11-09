import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 2] * numbers[numbers.length - 1];
    }
}