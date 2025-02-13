import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int zeroCount = 0;
        int correctCount = 0;
        for (int i = 0; i < lottos.length; i++) {
            int num = lottos[i];
            if (num != 0) {
                for (int j = 0; j < win_nums.length; j++) {
                    if (win_nums[j] == num) {
                        correctCount++;
                    }
                    if (win_nums[j] > num) {
                        break;
                    }
                }
            } else {
                zeroCount++;
            }
        }

        return new int[]{
                this.getGrade(zeroCount + correctCount),
                this.getGrade(correctCount)
        };
    }

    private int getGrade(int num) {
        return switch (num) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
