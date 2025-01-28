import java.util.Arrays;

class Solution {

    public int[] solution(int[][] score) {
        double[] average = new double[score.length];
        int[] answer = new int[score.length];

        for (int i = 0; i < average.length; i++) {
            average[i] = (double) (score[i][0] + score[i][1]) / 2;
        }

        for (int i = 0, grade = 1; i < average.length; i++) {
            if (grade > average.length) {
                break;
            }

            double maxValue = -1;
            for (int j = 0; j < average.length; j++) {
                if (average[j] > maxValue) {
                    maxValue = average[j];
                }
            }
            int cnt = 0;
            for (int k = 0; k < average.length; k++) {
                if (average[k] == maxValue) {
                    average[k] = -1;
                    answer[k] = grade;
                    cnt++;
                }
            }
            grade += cnt;
        }

        return answer;
    }
}
