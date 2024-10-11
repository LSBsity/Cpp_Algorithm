import java.util.Arrays;

class Solution {
    public int solution(String str) {
        return Arrays.stream(str.split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}