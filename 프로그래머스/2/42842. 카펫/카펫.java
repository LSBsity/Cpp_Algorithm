import java.util.Arrays;

class Solution {

    public int[] solution(int brown, int yellow) {
        for (int i = yellow; i >= 1; i--) {
            for (int j = 2; j <= yellow; j++) {
                if (i * j == yellow) {
                    if ((i + 2) * (j + 2) == brown + yellow) {
                        return new int[]{Math.max(i, j) + 2, Math.min(i, j) + 2};
                    }
                } else if (i * j >= yellow) {
                    break;
                }
            }
        }
        return new int[]{yellow + 2, yellow + 2};
    }
}