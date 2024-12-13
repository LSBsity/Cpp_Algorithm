import java.util.stream.IntStream;

class Solution {
    public int solution(String myString, String pat) {
        return (int) IntStream.range(0, myString.length() - pat.length() + 1)
                .filter(i -> myString.startsWith(pat, i))
                .count();
    }
}