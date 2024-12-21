import java.util.Arrays;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for (int i = 0, idx = 0, cnt = 0; i < emergency.length; i++) {
            int max = -1;
            for (int j = 0; j < emergency.length; j++) {
                if (emergency[j] > max) {
                    max = emergency[j];
                    idx = j;
                }
            }
            answer[idx] = ++cnt;
            emergency[idx] = -1;
        }

        return answer;
    }
}