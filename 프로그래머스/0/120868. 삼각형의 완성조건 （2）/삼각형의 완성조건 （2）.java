import java.util.Arrays;

class Solution {

    public int solution(int[] sides) {
        Arrays.sort(sides);

        if (sides[1] + 1 > sides[0]) {
            return sides[0] + (sides[0] - 1);
        }

        return sides[0];
    }
}