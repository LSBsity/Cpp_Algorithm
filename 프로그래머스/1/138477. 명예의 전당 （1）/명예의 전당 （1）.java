import java.util.Arrays;

class Solution {

    public int[] solution(int k, int[] scores) {
        int[] answer = new int[scores.length];
        int[] honor = new int[k];
        Arrays.fill(honor, Integer.MAX_VALUE);
        
        for (int i = 0; i < scores.length; i++) {
            if (k > i) {
                honor[i] = scores[i];
            } else {
                if (honor[0] < scores[i]) {
                    honor[0] = scores[i];
                }
            }
            Arrays.sort(honor);
            answer[i] = honor[0];
        }
        return answer;
    }
}
