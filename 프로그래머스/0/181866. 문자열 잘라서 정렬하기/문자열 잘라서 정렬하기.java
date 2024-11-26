import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        String[] tmp = myString.split("x");
        Arrays.sort(tmp);
        return Arrays.stream(tmp)
                .filter(str -> str.length() >= 1)
                .toArray(String[]::new);
    }
}