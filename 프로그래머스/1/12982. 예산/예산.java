import java.util.*;

class Solution {

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for (int val : d) {
            if (budget >= val) {
                budget -= val;
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}