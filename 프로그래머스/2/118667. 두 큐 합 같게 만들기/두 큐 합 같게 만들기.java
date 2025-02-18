import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        int cnt = 0;
        while (sum1 != sum2) {
            if (sum1 > sum2) {
                Integer q1Poll = q1.poll();
                q2.add(q1Poll);
                sum1 -= q1Poll;
                sum2 += q1Poll;
            } else {
                Integer q2Poll = q2.poll();
                sum2 -= q2Poll;
                q1.add(q2Poll);
                sum1 += q2Poll;
            }
            cnt++;
            if (cnt >= 100_000_000) return -1;
        }

        return cnt;
    }
}