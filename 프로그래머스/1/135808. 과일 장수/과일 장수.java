import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        
        int min = Integer.MAX_VALUE;
        for (int i = score.length - 1, cnt = 0; i >= 0; i--, cnt++) {
            int value = score[i];
            if (value < min) {
                min = value;
            }
            if ((cnt + 1) % m == 0) {
                answer += min * m;
            }
        }
        
        return answer;
    }
}