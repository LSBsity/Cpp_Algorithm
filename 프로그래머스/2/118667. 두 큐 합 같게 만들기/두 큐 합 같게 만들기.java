import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        
        int limit = 4 * q1.size();
        while (sum1 != sum2) {
            if (answer > limit) return -1;
            
            if (sum1 > sum2) {
                int i2 = q1.poll();
                sum2 += i2;
                sum1 -= i2;
                q2.offer(i2);
            } else {
                int i1 = q2.poll();
                sum1 += i1;
                sum2 -= i1;
                q1.offer(i1);
            }
            answer++;
        }
        
        return answer;
    }
}