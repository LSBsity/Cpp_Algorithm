import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        return Arrays.stream(my_string.split(""))
                .filter(i -> i.charAt(0) >= '0' && i.charAt(0) <= '9')
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}